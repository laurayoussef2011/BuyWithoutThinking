package com.SWEProject.Entities;

import javax.persistence.*;

@Entity
public class User {
    @Id
    protected String Username;
    protected String Name;
    protected String Email;
    protected String Type;
    protected String Password;

    public User(){
        Name = "";
        Email = "";
        Type = "";
        Username = "";
        Password = "";
    }

    public User(String name, String email, String username, String password, String type) {
        Name = name;
        Email = email;
        Type = type;
        Username = username;
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
