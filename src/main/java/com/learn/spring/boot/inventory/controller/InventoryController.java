package com.learn.spring.boot.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learn.spring.boot.inventory.model.Inventory;
import com.learn.spring.boot.inventory.repository.InventoryRepository;

/**
 * Has mappings of requests.
 * @RestController = @Controller + @ResponseBody
 * @author Karen
 *
 */
@RestController
public class InventoryController {
	
	@Autowired
	InventoryRepository inventoryRepository;
	
	/**
	 * Fetches all inventories from db.
	 * @return list of inventories
	 */
	@RequestMapping(value = "/inventories", method = RequestMethod.GET)
	public List<Inventory> getAllInventory(){
		return inventoryRepository.findAll();		
		
	}
	
}
