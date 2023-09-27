package com.bubblebear.backendProject.service;

import java.util.List;

import com.bubblebear.backendProject.entity.Categories;

public interface CategoryService  {

	List<Categories> getAllCategories();

	Categories getCategoryByBid (long id);
	
	Categories createCategory (Categories category);
	
	Categories updateCategory (long id);
	
	void deleteCategory (long id);
	
	
}
