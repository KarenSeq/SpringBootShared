package com.learn.spring.boot.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * Entity for ORM
 * @Data lombok annotation to generate getters and setters
 * @author Karen
 *
 */
@Data
@Entity
public class Inventory {
	
	@Id
	private int id;

	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "quantity")
	private String quantity;
	
	@Column(name = "price_per_unit")
	private String price;
}
