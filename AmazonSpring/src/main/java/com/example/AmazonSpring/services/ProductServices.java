package com.example.AmazonSpring.services;

import com.example.AmazonSpring.models.Product;
import com.example.AmazonSpring.models.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {

    @Autowired
    private ProductRepository repository;
    public List<Product> getProducts()
    {
        return repository.findAll();
    }
    public Optional<Product> getAProduct(String id)
    {
        return repository.findById(id);
    }

    public void insertProduct(Product product)
    {
        repository.insert(product);
    }

    public void removeProduct(String id)
    {
        repository.deleteById(id);
    }

    public List<Product> productCategory(String category)
    {
        return repository.getByCategory(category);
    }

    public List<Product> bestsellerProduct(Boolean bestseller)
    {
        return repository.getByBestseller(bestseller);
    }


}
