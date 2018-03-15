package com.SWEProject.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ModelID;
    private String Name;

    public ProductModel()
    {
        Name="";
    }

    public ProductModel(String name) {
        Name = name;
    }


    public Integer getModelID() {
        return ModelID;
    }

    public void setModelID(Integer modelID) {
        ModelID = modelID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}