package com.learn.spring.boot.inventory.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learn.spring.boot.inventory.exception.BadRequestException;
import com.learn.spring.boot.inventory.exception.ItemNotFoundException;
import com.learn.spring.boot.inventory.mapper.GenericMapper;
import com.learn.spring.boot.inventory.model.Inventory;
import com.learn.spring.boot.inventory.repository.InventoryRepository;

/**
 * Has mappings of requests.
 * 
 * @RestController = @Controller + @ResponseBody
 * @author Karen
 *
 */
@RestController
public class InventoryController {

	private static final Logger log = LoggerFactory.getLogger(InventoryController.class);

	@Autowired
	InventoryRepository inventoryRepository;

	@Autowired
	GenericMapper mapper;

	/**
	 * Fetches all inventories from db.
	 * 
	 * @return list of inventories
	 */
	@RequestMapping(value = "/inventories", method = RequestMethod.GET)
	public List<Inventory> getAllInventory() {

		log.info("Retrieving all inventories");

		List<Inventory> inventories = new ArrayList<>();
		inventoryRepository.findAll().stream().forEach(inventory -> inventories.add(mapper.convert(inventory)));

		return inventories;
	}

	/**
	 * Fetches inventory details of inventory with id in request
	 * 
	 * @param id item id of the inventory
	 * @return inventory details corresponding to input id
	 * @throws ItemNotFoundException thrown when item with input id is not present
	 */
	@RequestMapping(value = "/inventory/{id}", method = RequestMethod.GET)
	public Inventory getInventory(@PathVariable(value = "id") String id) throws ItemNotFoundException {
		int itemId = Integer.parseInt(id);
		try {
			log.info("Retrieving iventory item with id = " + id);

			return mapper.convert(inventoryRepository.findById(itemId).get());
		} catch (NoSuchElementException e) {
			throw new ItemNotFoundException(id, e.getMessage());
		}
	}

	/**
	 * Archives a new inventory item
	 * 
	 * @param inventory item to be added
	 * @return message on successful archival
	 * @throws BadRequestException thrown when item ingestion fails
	 */
	@RequestMapping(value = "/inventory/add", method = RequestMethod.POST)
	public String addInventory(@RequestBody Inventory inventory) throws BadRequestException {
		com.learn.spring.boot.inventory.entity.Inventory inventoryEntity = null;
		try {
			log.info("Adding iventory item with name = " + inventory.getItemName());

			inventoryEntity = inventoryRepository.save(mapper.convert(inventory));

		} catch (IllegalArgumentException | DataIntegrityViolationException ex) {
			log.error(ex.getMessage());
			throw new BadRequestException(inventory.getItemName(), ex.getMessage());
		}

		log.info("Inventory item '" + inventory.getItemName() + "' successfully added with id = "
				+ inventoryEntity.getId());
		return "Item added successfully with id " + inventoryEntity.getId();
	}

}
