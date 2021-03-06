package com.learn.spring.boot.inventory.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learn.spring.boot.inventory.exception.BadRequestException;
import com.learn.spring.boot.inventory.exception.ItemNotFoundException;
import com.learn.spring.boot.inventory.model.Inventory;
import com.learn.spring.boot.inventory.service.impl.InventoryServiceImpl;

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
	InventoryServiceImpl inventoryService;

	/**
	 * Fetches all inventories from db.
	 * 
	 * @return list of inventories
	 */
	@RequestMapping(value = "/inventories", method = RequestMethod.GET)
	public List<Inventory> getAllInventory() {

		log.info("Retrieving all inventories");

		return inventoryService.getAllInventory();
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

		log.info("Retrieving iventory item with id = " + id);

		return inventoryService.getInventory(id);
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

		log.info("Adding inventory item with name = " + inventory.getItemName());

		return inventoryService.addInventory(inventory);
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
	@RequestMapping(value = "/inventory/{id}", method = RequestMethod.DELETE)
	public String deleteInventory(@PathVariable(value = "id") String id)
			throws ItemNotFoundException, BadRequestException {

		log.info("Deleting inventory with id " + id);

		return inventoryService.deleteInventory(id);
	}

}
