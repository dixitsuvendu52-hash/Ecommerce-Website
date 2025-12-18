package com.example.demo.controller;



import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	
	@Autowired
	  private  ProductService productService;
   // private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> all(@RequestParam(value = "category", required = false) String category,
                                             @RequestParam(value = "search", required = false) String search) {
        List<Product> result = productService.getAll();
        if (category != null) {
            Long categoryId = Long.parseLong(category);
            result = productService.getByCategory(categoryId);
        }
        if (search != null && !search.isBlank())
            result = result.stream().filter(p -> p.getName() != null && p.getName().toLowerCase().contains(search.toLowerCase())).toList();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id) {
        Product p = productService.findById(id);
        if (p == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(p);
    }
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getProductsByCategory(
            @PathVariable("categoryId") Long categoryId) {

        return ResponseEntity.ok(
            productService.getByCategory(categoryId)
        );
    }
    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        Product created = productService.save(product);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

