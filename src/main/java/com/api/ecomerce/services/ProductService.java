package com.api.ecomerce.services;

import com.api.ecomerce.entities.Product;
import com.api.ecomerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void delete(Product product){
        productRepository.delete(product);
    }
    public Optional<Product> findById(UUID id) {
        return productRepository.findById(id);
    }




}
