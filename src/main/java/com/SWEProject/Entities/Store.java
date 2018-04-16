package com.SWEProject.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Store {
    @Id
    private String Storename;
    private String Storeowner;
    private String Type;


    public Store() {
        Storename = "";
        Storeowner = "";
        Type= "";
    }

    public Store(String storeowner, String storename, String type) {
        Storeowner = storeowner;
        Storename = storename;
        Type = type;
    }

    public void setStoreowner(String storeowner) {
        Storeowner = storeowner;
    }

    public void setStorename(String storename) {
        Storename = storename;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getStoreowner() {
        return Storeowner;
    }

    public String getStorename() {
        return Storename;
    }

    public String getType() {
        return Type;
    }
}
