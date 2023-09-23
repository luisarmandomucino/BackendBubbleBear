package com.bubblebear.backendProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bubblebear.backendProject.entity.Product;



public interface ProductRepository extends CrudRepository<Product, Long> {

	  //Optional<Product> findById(long id);
	  Product findById(long id);
}