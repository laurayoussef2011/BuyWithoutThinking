package com.SWEProject.service;

import com.SWEProject.Entities.Product;
import com.SWEProject.Entities.Statistics;
import com.SWEProject.Entities.User;
import com.SWEProject.repository.StatRepository;
import com.SWEProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Service

public class userService {

    @Autowired
    UserRepository userRep;
    @Autowired
    StatRepository statRepository;

    public boolean addUser(User user)
    {

        if(user.getName().equals("") || user.getUsername().equals("") ||
                user.getPassword().equals("") || user.getEmail().equals("") || user.getType().equals(""))
        {
            return false;
        }
        if(userRep.exists(user.getUsername()))
        {
            return false;
        }
        userRep.save(user);
        return  true;

    }

    public User checkAvailable(User user )
    {
        if(user.getUsername().equals("") || user.getPassword().equals("") || user.getType().equals(""))
        {
            System.out.println("there is missing data");
            return user;
        }
        if(userRep.exists(user.getUsername())) {
            User FoundUser = userRep.findOne(user.getUsername());

            if (user.getUsername().equals(FoundUser.getUsername()) && user.getPassword().equals(FoundUser.getPassword()) &&
                    user.getType().equals(FoundUser.getType())) {
                return FoundUser;
            }
            else
            {
                return user;
            }
        }
        System.out.println("this user is not avail ");
        return user;
    }

    public List<User> showCollaborators(String storeName)
    {

        Iterable<User> userIterable = userRep.findAll();
        List<User> userList = new ArrayList<>();
        for(User user : userIterable)
        {
            if(user.getStorename().equals(storeName) && user.getType().equals("collaborator"))
            {
                userList.add(user);
            }
        }

        return userList;

    }

    public boolean addStat(String method)
    {
        Statistics statistic = new Statistics(method);
        if(statRepository.exists(method))
        {
            return false;
        }
        statRepository.save(statistic);
        return  true;
    }
}
