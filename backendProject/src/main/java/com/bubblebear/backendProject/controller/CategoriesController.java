package com.bubblebear.backendProject.controller;



import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bubblebear.backendProject.entity.Categories;

@RestController
@RequestMapping
public class CategoriesController {
	
	@GetMapping
	public List<Categories> getAllCategories() {
		return null;
		
	}
	
	@GetMapping("{id}")
	public Categories getCategoryById(@PathVariable long id) {
		return null;
	}
	
	
	
	@PostMapping("{id}")
	public Categories updateCategory( @RequestBody Categories category) {
		return category;
	}
	
	
	@PutMapping("{id}")
	public Categories createCategory(@PathVariable long id, @RequestBody Categories category) {
		return category;
	}

	@DeleteMapping("{id}")
	public void deleteCategory(@PathVariable long id) {
		
	}
	
}
