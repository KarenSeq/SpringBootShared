package com.learn.spring.boot.inventory.mapper;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.spring.boot.inventory.model.Inventory;

/**
 * Converts entity to POJO.
 * 
 * @author Karen
 *
 */
@Component
public class GenericMapper {

	/**
	 * Converts {@link com.learn.spring.boot.inventory.entity.Inventory} entity to
	 * {@link Inventory}
	 * 
	 * @param inventory entity
	 * @return inventory POJO
	 */
	public Inventory convert(com.learn.spring.boot.inventory.entity.Inventory inventory) {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.convertValue(inventory, Inventory.class);
	}

	/**
	 * Converts {@link Inventory} entity to
	 * {@link com.learn.spring.boot.inventory.entity.Inventory}
	 * 
	 * @param inventory POJO
	 * @return inventory entity
	 */
	public com.learn.spring.boot.inventory.entity.Inventory convert(Inventory inventory) {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.convertValue(inventory, com.learn.spring.boot.inventory.entity.Inventory.class);
	}

}
