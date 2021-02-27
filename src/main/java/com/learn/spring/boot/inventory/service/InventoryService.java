package com.learn.spring.boot.inventory.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.learn.spring.boot.inventory.exception.BadRequestException;
import com.learn.spring.boot.inventory.exception.ItemNotFoundException;
import com.learn.spring.boot.inventory.model.Inventory;

/**
 * Has inventory service definitions
 * 
 * @author Karen
 *
 */
public interface InventoryService {

	/**
	 * Fetches all inventories from db.
	 * 
	 * @return list of inventories
	 */
	public List<Inventory> getAllInventory();

	/**
	 * Fetches inventory details of inventory with id in request
	 * 
	 * @param id item id of the inventory
	 * @return inventory details corresponding to input id
	 * @throws ItemNotFoundException thrown when item with input id is not present
	 */
	public Inventory getInventory(String id) throws ItemNotFoundException;

	/**
	 * Archives a new inventory item
	 * 
	 * @param inventory item to be added
	 * @return message on successful archival
	 * @throws BadRequestException thrown when item ingestion fails
	 */
	public String addInventory(@RequestBody Inventory inventory) throws BadRequestException;

	/**
	 * Deletes an entry from Inventory
	 * 
	 * @param inventory details of Item to be deleted
	 * @return message of successful deletion
	 * @throws ItemNotFoundException exception is thrown in case item with provided
	 *                               id does not exist
	 * @throws BadRequestException   Exception is thrown when deletion fails
	 */
	public String deleteInventory(String id) throws BadRequestException;
}
