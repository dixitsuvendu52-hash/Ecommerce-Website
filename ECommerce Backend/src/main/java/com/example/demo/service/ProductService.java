package com.example.demo.service;


import com.example.demo.model.Product;
import java.util.List;

public interface ProductService {
//    Product save(Product product);
//    List<Product> getAll();
//    List<Product> getByCategory(String category);
//    Product findById(Long id);
//    void deleteById(Long id);
	
	   Product save(Product product);
	    List<Product> getAll();
	    List<Product> getByCategory(Long categoryId);
	    Product findById(Long id);
	    void deleteById(Long id);
	  
}
