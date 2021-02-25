package com.learn.spring.boot.inventory.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Exception for incorrect request
 * 
 * @author Karen
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class BadRequestException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9176518093836245325L;

	private String name;

	private String message;

}
