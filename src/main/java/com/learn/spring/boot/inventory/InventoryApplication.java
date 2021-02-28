package com.learn.spring.boot.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Boots up the application.
 * 
 * @SpringBootApplication = @Configuration + @EnableAutoConfiguration
 *                        + @ComponentScan
 * @EnableSwagger2 - for documentation
 * @author Karen
 *
 */
@SpringBootApplication
@EnableSwagger2
public class InventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	}

}
