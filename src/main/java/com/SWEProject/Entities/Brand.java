package com.SWEProject.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

public class Brand {
    @Id
    private String BrandID;
    private String Name;

    public Brand() {
        BrandID = "";
        Name = "";
    }

    public Brand(String brandID, String name) {
        BrandID = brandID;
        Name = name;
    }

    public String getBrandID() {
        return BrandID;
    }

    public void setBrandID(String brandID) {
        BrandID = brandID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
