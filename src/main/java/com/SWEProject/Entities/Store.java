package com.SWEProject.Entities;

import java.util.Vector;

public class Store {
    private String Name;
    private String ID;
    private Vector<Product> myProduct;

    public Store(String name, String ID, Vector<Product> myProduct) {
        Name = name;
        this.ID = ID;
        this.myProduct = myProduct;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Vector<Product> getMyProduct() {
        return myProduct;
    }

    public void setMyProduct(Vector<Product> myProduct) {
        this.myProduct = myProduct;
    }
}
