package com.SWEProject.controller;


import com.SWEProject.Entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {


    @GetMapping("/Register")
    public String ShowRegister(Model model)
    {
        model.addAttribute("User",new User());
        return "register";
    }

    @PostMapping("/Register")
    public String Register(Model model,@ModelAttribute User user)
    {
        System.out.println(user.getName());
        System.out.println(user.getPassword());
        model.addAttribute("User",new User());
        return "register";
    }
}
