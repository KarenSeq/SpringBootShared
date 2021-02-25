package com.learn.spring.boot.inventory.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Exception for when item is not present in the archive
 * @author Karen
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class ItemNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String itemId;

	private String message;

}
