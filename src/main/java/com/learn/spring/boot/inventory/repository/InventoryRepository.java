package com.learn.spring.boot.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.spring.boot.inventory.model.Inventory;

/**
 * JpaRepository is the JPA specific Repository interface. 
 * Parameters - 'Inventory' is the entity and 'Integer' is the data type of the primary key
 * @author Karen
 *
 */
public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

}
