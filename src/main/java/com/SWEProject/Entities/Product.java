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
    private Integer Price;
    private String Model;
    private String Brand;
    private Integer Views;
    private  Integer Quantity;
    private boolean Available;


    public Product() {
        Productname = "";
        Price = 0;
        Model = "";
        Brand = "";
        Storename = "";
        Views = 0;
        Quantity = 0;
        Available = true;
    }

    public Product(String productName, String storeName, Integer price, String model, String brand, Integer views ,Integer quantity, boolean available) {
        Productname = productName;
        Storename = storeName;
        Price = price;
        Model = model;
        Brand = brand;
        Views = views;
        Quantity = quantity;
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

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
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

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public boolean getAvailable() {
        return Available;
    }

    public void setAvailable(boolean available) {
        Available = available;
    }
}
