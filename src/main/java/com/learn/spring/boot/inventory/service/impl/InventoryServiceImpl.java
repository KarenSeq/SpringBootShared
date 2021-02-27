package com.learn.spring.boot.inventory.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.learn.spring.boot.inventory.exception.BadRequestException;
import com.learn.spring.boot.inventory.exception.ItemNotFoundException;
import com.learn.spring.boot.inventory.mapper.GenericMapper;
import com.learn.spring.boot.inventory.model.Inventory;
import com.learn.spring.boot.inventory.repository.InventoryRepository;
import com.learn.spring.boot.inventory.service.InventoryService;

/**
 * Has business logic of all service w.r.t inventory
 * 
 * @author Karen
 *
 */
@Service
public class InventoryServiceImpl implements InventoryService {

	private static final Logger log = LoggerFactory.getLogger(InventoryServiceImpl.class);

	@Autowired
	InventoryRepository inventoryRepository;

	@Autowired
	GenericMapper mapper;

	/**
	 * Fetches all inventories from db.
	 * 
	 * @return list of inventories
	 */
	@Override
	public List<Inventory> getAllInventory() {

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
	@Override
	public Inventory getInventory(String id) throws ItemNotFoundException {

		int itemId = Integer.parseInt(id);
		try {
			// log.info("Retrieving iventory item with id = " + id);

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
	@Override
	public String addInventory(Inventory inventory) throws BadRequestException {
		com.learn.spring.boot.inventory.entity.Inventory inventoryEntity = null;
		try {
			log.info("Adding inventory item with name = " + inventory.getItemName());

			inventoryEntity = inventoryRepository.save(mapper.convert(inventory));

		} catch (IllegalArgumentException | DataIntegrityViolationException ex) {
			log.error(ex.getMessage());
			throw new BadRequestException(inventory.getItemName(), ex.getMessage());
		}

		log.info("Inventory item '" + inventory.getItemName() + "' successfully added with id = "
				+ inventoryEntity.getId());
		return "Item added successfully with id " + inventoryEntity.getId();
	}

	/**
	 * Deletes an entry from Inventory
	 * 
	 * @param inventory details of Item to be deleted
	 * @return message of successful deletion
	 * @throws ItemNotFoundException exception is thrown in case item with provided
	 *                               id does not exist
	 * @throws BadRequestException   Exception is thrown when deletion fails
	 */
	@Override
	public String deleteInventory(String id) throws BadRequestException {
		com.learn.spring.boot.inventory.entity.Inventory inventoryEntity = null;
		try {
			log.info("Deleting inventory with id " + id);
			inventoryEntity = inventoryRepository.findById(Integer.parseInt(id)).get();
			inventoryRepository.delete(inventoryEntity);
		} catch (IllegalArgumentException | DataIntegrityViolationException ex) {
			log.error(ex.getMessage());
			throw new BadRequestException(id, ex.getMessage());
		}
		log.info("Inventory item '" + inventoryEntity.getItemName() + "' successfully deleted with id = "
				+ inventoryEntity.getId());
		return "Item deleted successfully with id " + inventoryEntity.getId();
	}

}
