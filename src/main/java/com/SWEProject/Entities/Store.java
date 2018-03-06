package com.SWEProject.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Vector;

@Entity
public class Store {
    @Id
    private String ID;
    private String Name;
    private Vector<Product> myProduct;

    public Store() {
        Name = "";
        this.ID = "";
        this.myProduct = new Vector<>();
    }

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
