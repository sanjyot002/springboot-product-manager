package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Model.Product;
import com.app.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository ProdRepo;
	
	//Retrive List of Product
	public List<Product> getAll(){
		return ProdRepo.findAll();
	}
	
	//Retrive the Product by Id
	public Optional<Product> getProductById(int id) {
		
		return ProdRepo.findById(id);
	}

	//Save the Product
	public Product saveProduct(Product p) {
		return ProdRepo.save(p);
	}
	
	//Delete the Product
	public void deleteProduct(int id) {
		ProdRepo.deleteById(id);
	}
}
