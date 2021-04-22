package com.example.AmazonSpring.controllers;

import com.example.AmazonSpring.Response;
import com.example.AmazonSpring.models.Product;
import com.example.AmazonSpring.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collections;

@CrossOrigin
@RestController
public class ProductController {

    @Autowired
    private ProductServices prodServices;

    @GetMapping("/bestseller")
    public ResponseEntity getBestsellerProduct()
    {
        var response = new Response(prodServices.bestsellerProduct(true), "Only BestSeller Products");
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity getAProduct(@PathVariable("id") String id)
    {

        var response = new Response(Collections.singletonList(prodServices.getAProduct(id)),"Selected Product");

        return new ResponseEntity(response,HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity getProducts()
    {
        var response = new Response(prodServices.getProducts(), "Products");
        return new ResponseEntity(response,HttpStatus.OK);
    }


    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") String id)
    {
        prodServices.removeProduct(id);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "/products/insert",consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity addProduct(@RequestBody Product product)
    {

        prodServices.insertProduct(product);

        return new ResponseEntity(product,HttpStatus.OK);

    }

    @PostMapping(value = "/category",consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity productCategory(@RequestBody Product product)
    {
        var response = new Response(prodServices.productCategory(product.getCategory()), "Category Products");
        return new ResponseEntity(response, HttpStatus.OK);
    }


}
