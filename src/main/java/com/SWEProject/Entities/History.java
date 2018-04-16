package com.SWEProject.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer counter;
    private Integer serial_number;
    private String collaborator_name;
    private String type;
    private Integer date;
    private String store_name;

    public History() {
        this.serial_number = 0;
        this.collaborator_name = "";
        this.type = "";
        this.date = 0;
        this.store_name = "";
    }

    public History(Integer serial_number, String collaborator_name, Integer date , String type, String store_name) {
        this.serial_number = serial_number;
        this.collaborator_name = collaborator_name;
        this.type = type;
        this.date = date;
        this.store_name = store_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public Integer getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(Integer serial_number) {
        this.serial_number = serial_number;
    }

    public String getCollaborator_name() {
        return collaborator_name;
    }

    public void setCollaborator_name(String collaborator_name) {
        this.collaborator_name = collaborator_name;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }
}
