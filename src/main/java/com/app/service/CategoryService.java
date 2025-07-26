package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Model.Category;
import com.app.Model.Product;
import com.app.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository CateRepo;
	
	// Retrive the List of Category
	public List<Category> getAllCategory(){
		return CateRepo.findAll();
	}
	
	// Retrive the Category by Id 
	public Optional<Category> getCategoryById(int id) {
		return CateRepo.findById(id);
	}
	
	// Save the Product
	public Category saveCategory(Category category) {
		return CateRepo.save(category);
	}
	
	//Delete the Product by Id 
	public void deleteCategoryById(int id) {
	 CateRepo.deleteById(id);
	}

}
