package com.api.ecomerce.controllers;

import com.api.ecomerce.entities.Product;
import com.api.ecomerce.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class ProductController {
    final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }



    @PostMapping
    public ResponseEntity<Object> saveProduct(Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findProduct(@PathVariable(value = "id") UUID id){
        Optional<Product> productOptional =productService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(productOptional.get());

    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id")UUID id,@RequestBody Product product) {
        Optional<Product> productOptional = productService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(productService.save(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id")UUID id) {
        Optional<Product> productOptional = productService.findById(id);
        productService.delete(productOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product Deleted! ");
    }
}
