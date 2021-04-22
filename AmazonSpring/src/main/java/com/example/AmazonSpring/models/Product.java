package com.example.AmazonSpring.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


public class Product {

    @Id
    private String id;
    private String title;
    private String price;
    private String image;
    private String desc;
    private String category;
    private Boolean bestseller;

    public Product() {
    }

    public Product(String id, String title, String price, String image, String desc, String category, Boolean bestseller) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.image = image;
        this.desc = desc;
        this.category = category;
        this.bestseller = bestseller;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getBestseller() {
        return bestseller;
    }

    public void setBestseller(Boolean bestseller) {
        this.bestseller = bestseller;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", image='" + image + '\'' +
                ", desc='" + desc + '\'' +
                ", category='" + category + '\'' +
                ", bestseller=" + bestseller +
                '}';
    }
}
