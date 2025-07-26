package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
