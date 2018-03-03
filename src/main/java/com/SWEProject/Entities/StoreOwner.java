package com.SWEProject.Entities;

import java.util.Vector;

public class StoreOwner {
    private Vector<Store> myStores;

    public StoreOwner(Vector<Store> myStores) {
        this.myStores = myStores;
    }

    public Vector<Store> getMyStores() {
        return myStores;
    }

    public void setMyStores(Vector<Store> myStores) {
        this.myStores = myStores;
    }
}
