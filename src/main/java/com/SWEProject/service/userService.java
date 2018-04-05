package com.SWEProject.service;

import com.SWEProject.Entities.User;
import com.SWEProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service

public class userService {

    @Autowired
    UserRepository userRep;

    public boolean addUser(User user){

        if(user.getName().equals("") || user.getUsername().equals("") ||
                user.getPassword().equals("") || user.getEmail().equals("") || user.getType().equals(""))
        {
            return false;
        }
        userRep.save(user);
        return  true;

    }

    public boolean checkAvailable(User user )
    {
        if(user.getUsername().equals("") || user.getPassword().equals("") || user.getType().equals(""))
        {
            return false;
        }
        if(userRep.exists(user.getUsername())) {
            User FoundUser = userRep.findOne(user.getUsername());

            if (user.getUsername().equals(FoundUser.getUsername()) && user.getPassword().equals(FoundUser.getPassword()) &&
                    user.getType().equals(FoundUser.getType())) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }
}
