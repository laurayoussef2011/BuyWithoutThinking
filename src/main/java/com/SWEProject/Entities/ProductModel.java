package com.SWEProject.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProductModel {
    @Id

    private String Name;

    public ProductModel()
    {
        Name="";
    }

    public ProductModel(String name) {
        Name = name;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}