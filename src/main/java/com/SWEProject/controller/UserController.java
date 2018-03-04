package com.SWEProject.controller;


import com.SWEProject.Entities.User;
import com.SWEProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserRepository rep;

    @GetMapping("/Register")
    public String ShowRegister(Model model)
    {
        model.addAttribute("user", new User());
        return "register";
    }

    @RequestMapping("/Register")
    public String Register(Model model, @ModelAttribute User user )
    {
        model.addAttribute("user", new User());
        rep.save(user);

        return "register";
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/Login")
    public String ShowLogin(Model model)
    {
        model.addAttribute("user", new User());
        return "login";
    }

    @RequestMapping("/Login")
    public String Login(Model model, @ModelAttribute User user )
    {
        model.addAttribute("user", new User());

        //rep.exists(user.getUsername());

        return "login";
    }
}
