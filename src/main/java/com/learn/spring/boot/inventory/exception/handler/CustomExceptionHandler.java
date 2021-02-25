package com.learn.spring.boot.inventory.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.learn.spring.boot.inventory.exception.BadRequestException;
import com.learn.spring.boot.inventory.exception.ItemNotFoundException;

/**
 * Handles exception and sends proper response to client
 * 
 * @author Karen
 *
 */
@ControllerAdvice
public class CustomExceptionHandler {

	/**
	 * Response handling for {@link ItemNotFoundException}
	 * 
	 * @param ex thrown when item is not found in the archive
	 * @return {@link ResponseEntity}
	 */
	@ExceptionHandler(value = ItemNotFoundException.class)
	public ResponseEntity<Object> toError(ItemNotFoundException ex) {
		return new ResponseEntity<Object>(ex.getMessage() + " for id " + ex.getItemId(), HttpStatus.NOT_FOUND);
	}

	/**
	 * Response handling for {@link BadRequestException}
	 * 
	 * @param ex thrown when request is incorrect
	 * @return {@link ResponseEntity}
	 */
	@ExceptionHandler(value = BadRequestException.class)
	public ResponseEntity<Object> toError(BadRequestException ex) {
		return new ResponseEntity<Object>("Item '" + ex.getName() + "' could not be ingested because of incorrect request",
				HttpStatus.BAD_REQUEST);
	}

}
