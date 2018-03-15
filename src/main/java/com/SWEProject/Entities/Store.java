package com.SWEProject.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Store {
    @Id
    private String StoreName;
    private String StoreOwner;
    private String Type;


    public Store() {
        StoreName = "";
        StoreOwner= "";
        Type= "";
    }

    public Store(String storeOwner, String storeName, String type) {
        StoreOwner = storeOwner;
        StoreName = storeName;
        Type = type;
    }

    public void setStoreOwner(String storeOwner) {
        StoreOwner = storeOwner;
    }

    public void setStoreName(String storeName) {
        StoreName = storeName;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getStoreOwner() {
        return StoreOwner;
    }

    public String getStoreName() {
        return StoreName;
    }

    public String getType() {
        return Type;
    }
}
