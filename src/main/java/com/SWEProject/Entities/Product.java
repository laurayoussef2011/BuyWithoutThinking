package com.SWEProject.Entities;

public class Product {
    private String ProductID;
    private Model myModel;
    private Brand myBrand;
    private double Price;
    private Store Store;

    public Product(String productID, Model myModel, Brand myBrand, double price, com.SWEProject.Entities.Store store) {
        ProductID = productID;
        this.myModel = myModel;
        this.myBrand = myBrand;
        Price = price;
        Store = store;
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public Model getMyModel() {
        return myModel;
    }

    public void setMyModel(Model myModel) {
        this.myModel = myModel;
    }

    public Brand getMyBrand() {
        return myBrand;
    }

    public void setMyBrand(Brand myBrand) {
        this.myBrand = myBrand;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public com.SWEProject.Entities.Store getStore() {
        return Store;
    }

    public void setStore(com.SWEProject.Entities.Store store) {
        Store = store;
    }
}
