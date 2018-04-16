package com.SWEProject.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SystemProduct {
    @Id
    private String Productname;
    private String Model;
    private String Brand;
    private double Price;

    public SystemProduct()
    {
        Productname = "";
        Price = 0.0;
        Model = "";
        Brand = "";
    }

    public SystemProduct(String productname, String model, String brand, double price) {
        Productname = productname;
        Model = model;
        Brand = brand;
        Price = price;
    }

    public String getProductname() {
        return Productname;
    }

    public void setProductname(String productname) {
        Productname = productname;
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

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
}
