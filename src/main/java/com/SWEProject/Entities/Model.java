package com.SWEProject.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;


public class Model {
    @Id
    private String ModelID;
    private String Name;

    public Model() {
        ModelID = "";
        Name = "";
    }

    public Model(String modelID, String name) {
        ModelID = modelID;
        Name = name;
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
}