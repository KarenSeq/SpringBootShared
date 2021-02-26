package com.learn.spring.boot.inventory.model;

import com.sun.istack.NotNull;

import lombok.Data;

/**
 * POJO for inventory details
 * @author Karen
 *
 */
@Data
public class Inventory {
	@NotNull
	private int id;
	@NotNull
	private String itemName;
	@NotNull
	private String quantity;
	@NotNull
	private String price;

}
