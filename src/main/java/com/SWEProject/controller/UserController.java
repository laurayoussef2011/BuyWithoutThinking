package com.SWEProject.controller;

import com.SWEProject.Entities.User;
import com.SWEProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {
    @Autowired
    private UserRepository rep;

    @GetMapping("//")
    public String DefaultPage(Model model)
    {
        model.addAttribute("user", new User());
        return "login";
    }

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
        if(user.getName().equals("") || user.getUsername().equals("") ||
                user.getPassword().equals("") || user.getEmail().equals("") || user.getType().equals(""))
        {
            return "register";
        }

        rep.save(user);

        return "register";
    }


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
        if(user.getUsername().equals("") || user.getPassword().equals(""))
        {
            return "login";
        }
        if(rep.exists(user.getUsername())) {
            User FoundUser = rep.findOne(user.getUsername());

            if (user.getUsername().equals(FoundUser.getUsername()) && user.getPassword().equals(FoundUser.getPassword())) {
                if (user.getType().equals(FoundUser.getType())) {
                    return user.getType() + "View";
                }
                else {
                    return "login";
                }

            }
        }
        return "login";
    }
}
