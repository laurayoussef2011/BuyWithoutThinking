package com.SWEProject.Entities;

public class Model {
    private String ModelID;
    private String Name;
    private Brand myBrand;
    private int view;

    public Model(String modelID, String name, Brand myBrand, int view) {
        ModelID = modelID;
        Name = name;
        this.myBrand = myBrand;
        this.view = view;
    }

    public String getModelID() {
        return ModelID;
    }

    public void setModelID(String modelID) {
        ModelID = modelID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Brand getMyBrand() {
        return myBrand;
    }

    public void setMyBrand(Brand myBrand) {
        this.myBrand = myBrand;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }
}