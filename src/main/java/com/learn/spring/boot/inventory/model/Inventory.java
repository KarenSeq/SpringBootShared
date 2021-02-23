package com.learn.spring.boot.inventory.model;

import lombok.Data;

/**
 * POJO for inventory details
 * @author Karen
 *
 */
@Data
public class Inventory {
	
	private int id;

	private String itemName;
	
	private String quantity;
	
	private String price;

}
