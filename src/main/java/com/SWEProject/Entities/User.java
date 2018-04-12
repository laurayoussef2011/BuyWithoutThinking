package com.SWEProject.Entities;

import javax.persistence.*;

@Entity
public class User {
    @Id
    protected String username;
    protected String name;
    protected String email;
    protected String type;
    protected String Password;
    protected String storename;
    protected Integer credit;

    public User(){
        name = "";
        email = "";
        type = "";
        username = "";
        Password = "";
        storename="";
        credit = 10000;
    }

    public User(String username, String name, String email, String type, String password, String storename, Integer credit) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.type = type;
        Password = password;
        this.storename = storename;
        this.credit = credit;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }
}
