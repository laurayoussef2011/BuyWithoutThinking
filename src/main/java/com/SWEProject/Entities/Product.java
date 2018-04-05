package com.SWEProject.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Serialnumber;
    private String Productname;
    private String Storename;
    private double Price;
    private String Model;
    private String Brand;
    private Integer Views;
    private boolean Available;


    public Product() {
        Productname = "";
        Price = 0.0;
        Model = "";
        Brand = "";
        Storename = "";
        Views = 0;
        Available = true;
    }

    public Product(String productName, String storeName, double price, String model, String brand, Integer views , boolean available) {
        Productname = productName;
        Storename = storeName;
        Price = price;
        Model = model;
        Brand = brand;
        Views = views;
        Available = available;
    }

    public Integer getSerialnumber() {
        return Serialnumber;
    }

    public void setSerialnumber(Integer serialnumber) {
        Serialnumber = serialnumber;
    }

    public String getProductname() {
        return Productname;
    }

    public void setProductname(String productname) {
        Productname = productname;
    }

    public String getStorename() {
        return Storename;
    }

    public void setStorename(String storename) {
        Storename = storename;
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

    public Integer getViews() {
        return Views;
    }

    public void setViews(Integer views) {
        Views = views;
    }

    public boolean getAvailable() {
        return Available;
    }

    public void setAvailable(boolean available) {
        Available = available;
    }
}
