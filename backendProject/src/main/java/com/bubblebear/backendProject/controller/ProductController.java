package com.bubblebear.backendProject.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bubblebear.backendProject.entity.Product;
import com.bubblebear.backendProject.service.ProductService;
import com.bubblebear.backendProject.implementation.ProductServiceImpl;

import lombok.extern.log4j.Log4j2;

@RestController //@Controller @ResponseBody
@RequestMapping("api/products")
@Log4j2
public class ProductController {
	@Autowired
	ProductService productService;
	/*
	@GetMapping
	public List<Product> getAllCustomers(){
		log.info("Solicitud get para todos los products");
		List <Product> products = (List<Product>) productRepository.findAll();
		return products; 
	}*/
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllCustomers(){
		List <Product> products = (List<Product>) productService.getAllProducts();
		return new ResponseEntity<>( products,HttpStatus.OK); 
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<Product> getProductById(@PathVariable long id) {
		return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
		
	}
	/*
	@PostMapping
	public Product insertNewProduct(@RequestBody Product producto) {
		producto.setId(null);
		Product newProduct = productRepository.save(producto);
		return newProduct;
	}*/
	
	@PostMapping
	public ResponseEntity<Product> insertNewProduct(@RequestBody Product producto) {
		return new ResponseEntity<>(productService.createProduct(producto), HttpStatus.CREATED);
	}
	

	/*
	@PutMapping("{id}")
	public Product updateProduct(@RequestBody Product producto, @PathVariable long id ) {
		Product newProduct = productRepository.findById(id);
		if( newProduct == null ) {
			throw new IllegalStateException("Product does not exist");
		}
		newProduct.setName(producto.getName());
		newProduct.setPrice(producto.getPrice());
		newProduct.setSize(producto.getSize());
		newProduct.setStock(producto.getStock());
		newProduct.setHide(producto.getHide());
		newProduct.setDescription(producto.getDescription());
		newProduct.setPhoto(producto.getPhoto());
		newProduct.setCategoryId(producto.getCategoryId());
		newProduct.setFlavor(producto.getFlavor());
		return productRepository.save(newProduct);
	}*/
	
	@PutMapping("{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product producto, @PathVariable long id ) {
		return new ResponseEntity<>(productService.updateProduct(producto, id),HttpStatus.OK);
	}
	/*
	@DeleteMapping("{id}")
	public String deleteProduct(@PathVariable long id) {
		Product producto = productRepository.findById(id);
		
		if(producto != null) {
			productRepository.delete(producto);
			return "Product deleted";
		}
		
		throw new IllegalStateException("Error, product not deleted");
	}*/
	
	@DeleteMapping("{id}")
	public void deleteProduct(@PathVariable long id) {
		productService.deleteProduct(id);
	}
	
	
}
