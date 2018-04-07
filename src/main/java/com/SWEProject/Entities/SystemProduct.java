package com.SWEProject.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SystemProduct {
    @Id
    private String ProductName;
    private String Model;
    private String Brand;
    private double Price;

    public SystemProduct()
    {
        ProductName = "";
        Price = 0.0;
        Model = "";
        Brand = "";
    }

    public SystemProduct(String productName, double price, String model, String brand) {
        ProductName = productName;
        Price = price;
        Model = model;
        Brand = brand;
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
}
