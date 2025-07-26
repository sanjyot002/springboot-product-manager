package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Model.Category;
import com.app.service.CategoryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService CateServ;
	
	@GetMapping
	public List<Category> getCategory(){
		return CateServ.getAllCategory();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") int id){
		Optional<Category> CategoryOpt = CateServ.getCategoryById(id);
		if(CategoryOpt.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(CategoryOpt.get());
	}
	
	@PostMapping
	public Category savCategory(@RequestBody Category category) {
		return CateServ.saveCategory(category);
	}
	
	@PutMapping("/{id}")
	public Category updateCategory(@PathVariable int id,@RequestBody Category category) {
		
		return CateServ.saveCategory(category);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
		Optional<Category> CategoryOpt = CateServ.getCategoryById(id);
		if(CategoryOpt.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		CateServ.deleteCategoryById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
