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
    private Integer ProductID;

    private String ProductName;
    private double Price;
    private String myModel;
    private String myBrand;
    private String Store;

    public Product() {
        ProductName = "";
        Price = 0.0;
        myModel = "";
        this.myBrand = "";
        Store = "";
    }

    public Product( String productName, double price, String myModel, String myBrand, String store) {
        ProductName = productName;
        Price = price;
        this.myModel = myModel;
        this.myBrand = myBrand;
        Store = store;
    }

    public Integer getProductID() {
        return ProductID;
    }

    public void setProductID(Integer productID) {
        ProductID = productID;
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

    public String getMyModel() {
        return myModel;
    }

    public void setMyModel(String myModel) {
        this.myModel = myModel;
    }

    public String getMyBrand() {
        return myBrand;
    }

    public void setMyBrand(String myBrand) {
        this.myBrand = myBrand;
    }

    public String getStore() {
        return Store;
    }

    public void setStore(String store) {
        Store = store;
    }
}
