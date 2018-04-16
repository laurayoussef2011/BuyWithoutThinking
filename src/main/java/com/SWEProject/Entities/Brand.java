package com.SWEProject.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Brand {
    @Id
    private String Brandname;

    public Brand()
    {
        Brandname ="";
    }

    public Brand(String name) {
        Brandname = name;
    }

    public String getBrandname() {
        return Brandname;
    }

    public void setBrandname(String name) {
        Brandname = name;
    }
}