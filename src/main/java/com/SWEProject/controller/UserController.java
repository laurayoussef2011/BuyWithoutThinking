package com.SWEProject.controller;


import com.SWEProject.Entities.User;
import com.SWEProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserRepository rep;
    @GetMapping("/Register")
    public String ShowRegister()
    {
        return "register";
    }

    @RequestMapping("/Register")
    public String Register(@RequestParam("name") String name , @RequestParam("username") String username ,@RequestParam("email") String email , @RequestParam("password") String password )
    {
        User user=new User(name,username,email,password);
        System.out.println(user.getName());
        rep.save(user);
        return "register";
    }
}
