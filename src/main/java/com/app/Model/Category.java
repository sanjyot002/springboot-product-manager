package com.app.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int categoryId;

@NotBlank(message="Category name is required.")
private String categoryName;


@OneToMany(mappedBy ="category",cascade=CascadeType.ALL)
@JsonManagedReference
private List<Product> products;
}
