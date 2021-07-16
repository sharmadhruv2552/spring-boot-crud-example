package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product product) {
		return repository.save(product);
	}
	
	public List<Product> saveProducts(List<Product> products) {
		return repository.saveAll(products);
	}
	
	public List<Product> getProducts() {
		return repository.findAll();
	}
	
	public Product getProductById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Product> getProductsByName(String name) {
		return repository.findByName(name);
	}
	
	public String deleteProduct(int id) {
		repository.deleteById(id);
		return "product removed !! "+id;
	}
	
	public Product updateProduct(Product product) {
		
		Product p = repository.findById(product.getId()).orElse(null);
		p.setPrice(product.getPrice());
		p.setName(product.getName());
		p.setQuantity(product.getQuantity());
		return repository.save(p);
		
	}

}
