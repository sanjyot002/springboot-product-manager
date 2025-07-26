package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.app.Model.Product;
import com.app.service.ProductService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService ProdServ;
	
	@GetMapping
	public List<Product> getProduct(){
		return ProdServ.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") int id) {
		Optional<Product> ProductOpt = ProdServ.getProductById(id);
		if(ProductOpt.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(ProductOpt.get());
	}
	
	@PostMapping
	public Product saveProduct(@RequestBody Product product) {
		return ProdServ.saveProduct(product);
		
	}
	
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable int id ,@RequestBody Product product) {
		
		return ProdServ.saveProduct(product);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
		Optional<Product> p = ProdServ.getProductById(id);
		if(p.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		ProdServ.deleteProduct(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	

}
