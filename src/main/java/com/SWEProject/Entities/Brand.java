package com.SWEProject.Entities;

import java.util.Vector;

public class Brand {
    private String Name;
    private String BrandID;
    private Vector<Model> myModel;

    public Brand(String name, String brandID, Vector<Model> myModel) {
        Name = name;
        BrandID = brandID;
        this.myModel = myModel;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBrandID() {
        return BrandID;
    }

    public void setBrandID(String brandID) {
        BrandID = brandID;
    }

    public Vector<Model> getMyModel() {
        return myModel;
    }

    public void setMyModel(Vector<Model> myModel) {
        this.myModel = myModel;
    }
}
