package com.bubblebear.backendProject.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bubblebear.backendProject.entity.Categories;
import com.bubblebear.backendProject.repository.CategoriesRepository;

@RestController
@RequestMapping ("api/categories")
public class CategoriesController {
	@Autowired
	CategoriesRepository categoriesRepository;
	
	@GetMapping
	public List<Categories> getAllCategories() {
		return null;
		
	}
	
	@GetMapping("{id}")
	public Categories getCategoryById(@PathVariable long id) {
	    Categories category = categoriesRepository.findById(id);
	    return category;
	}
	
	
	
	@PostMapping()
	public Categories createCategory( @RequestBody Categories createdCategory) {
		return createdCategory;
	}
	
	
	@PutMapping("{id}")
	public Categories updateCategory(@PathVariable long id, @RequestBody Categories category) {
		return category;
	}

	@DeleteMapping("{id}")
	public void deleteCategory(@PathVariable long id) {
		
	}
	
}
