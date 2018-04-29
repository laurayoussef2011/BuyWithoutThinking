package com.SWEProject.controllers;

import com.SWEProject.Entities.User;
import com.SWEProject.repository.UserRepository;
import com.SWEProject.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/userAPI")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")

public class UserController {

    @Autowired
    private UserRepository userRep;
    @Autowired
    private userService userServ;

    @GetMapping("/users")
    public List<User> getUsers()
    {
        return (List<User>) userRep.findAll();
    }

    @GetMapping("/user/{username}")
    public User getUser(@PathVariable String username)
    {
        return userRep.findOne(username);
    }

    @DeleteMapping("/deleteUser/{username}")
    public List<User> deleteUser(@PathVariable String username)
    {
         userRep.delete(username);
         return (List<User>) userRep.findAll();
    }

    @DeleteMapping("/deleteUsers")
    public List<User> deleteUsers()
    {
        userRep.deleteAll();
        return (List<User>) userRep.findAll();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @PostMapping("/createUser")
    public boolean register(@RequestBody User user)
    {
       return userServ.addUser(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user)
    {
       return userServ.checkAvailable(user);
    }

    @PostMapping("/showCollaborators/{storeName}")
    public List<User> showCollaborators( @PathVariable String storeName)
    {
        return userServ.showCollaborators(storeName);
    }

    @PostMapping("/addStat/{method}")
    public boolean addStat( @PathVariable String method)
    {
        return userServ.addStat(method);
    }


}