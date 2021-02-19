package com.learn.spring.boot.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Boots up the application.
 * @SpringBootApplication = @Configuration + @EnableAutoConfiguration + @ComponentScan
 * @author Karen
 *
 */
@SpringBootApplication
public class InventoryApplication{

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

}
