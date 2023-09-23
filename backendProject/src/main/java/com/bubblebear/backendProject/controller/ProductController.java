package com.bubblebear.backendProject.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bubblebear.backendProject.entity.Product;
import com.bubblebear.backendProject.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@RestController //@Controller @ResponseBody
@RequestMapping("api/products")
@Log4j2
public class ProductController {
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping
	public List<Product> getAllCustomers(){
		log.info("Solicitud get para todos los products");
		List <Product> products = (List<Product>) productRepository.findAll();
		return products; 
	}
	
	
}
