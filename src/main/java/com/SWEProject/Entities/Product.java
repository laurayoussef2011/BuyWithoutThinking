package com.SWEProject.Entities;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer SerialNumber;
    private String ProductName;
    private String StoreName;
    private double Price;
    private String Model;
    private String Brand;
    private Integer Views;


    public Product() {
        ProductName = "";
        Price = 0.0;
        Model = "";
        Brand = "";
        StoreName = "";
        Views = 0;
    }

    public Product(String productName, String storeName, double price, String model, String brand, Integer views) {
        ProductName = productName;
        StoreName = storeName;
        Price = price;
        Model = model;
        Brand = brand;
        Views = views;
    }

    public Integer getSerialNumber() {
        return SerialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        SerialNumber = serialNumber;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getStoreName() {
        return StoreName;
    }

    public void setStoreName(String storeName) {
        StoreName = storeName;
    }

    public Integer getViews() {
        return Views;
    }

    public void setViews(Integer views) {
        Views = views;
    }
}
