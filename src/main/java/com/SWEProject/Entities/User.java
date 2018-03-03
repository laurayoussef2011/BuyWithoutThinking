package com.SWEProject.Entities;

//@Entity
public class User {
//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
//    private Integer id;

    private String Name;
    private String Email;
    private String Username;
    private String Password;

    public User(){
        Name = "";
        Email = "";
        Username = "";
        Password = "";
    }

    public User(String name, String email, String username, String password) {
        Name = name;
        Email = email;
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
}
