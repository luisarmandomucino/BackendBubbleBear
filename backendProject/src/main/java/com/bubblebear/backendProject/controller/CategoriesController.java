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

import com.bubblebear.backendProject.entity.Categories;
import com.bubblebear.backendProject.repository.CategoriesRepository;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping ("api/categories")
public class CategoriesController {
	@Autowired
	CategoriesRepository categoriesRepository;
	
	@GetMapping
	public List<Categories> getAllCategories() {
		List<Categories> categories = (List <Categories>) categoriesRepository.findAll();
		return categories;
	}
	
	
	@GetMapping("{id}")
	public Categories getCategoryById(@PathVariable long id) {
	    Categories category = categoriesRepository.findById(id);
	    return category;
	}
	
	
	
	@PostMapping()
	public ResponseEntity<Categories> createCategory( @RequestBody Categories category) {
		Categories savedCategory = categoriesRepository.save(category);
		return new ResponseEntity<>(savedCategory, HttpStatus.CREATED) ;
	}
	
	
	@PutMapping("{id}")
	public Categories updateCategory(@PathVariable long id, @RequestBody Categories category) {
		Categories existingCategory = categoriesRepository.findById(id);
		if (existingCategory == null) {
	        throw new IllegalStateException("Category not found");
	    }
		existingCategory.setOutstanding(category.isOutstanding());
		existingCategory.setSale(category.isSale());
		return categoriesRepository.save(existingCategory);
	}

	@DeleteMapping("{id}")
	public void deleteCategory(@PathVariable long id) {
	    Categories deletedCategory = categoriesRepository.findById(id);

	    if (deletedCategory == null) {
	        throw new EntityNotFoundException("Category not found");
	    }

	    try {
	        categoriesRepository.delete(deletedCategory);
	    } catch (Exception e) {
	       
	        throw new RuntimeException("Failed to delete category: " + e.getMessage());
	    }
	}

	
}


































