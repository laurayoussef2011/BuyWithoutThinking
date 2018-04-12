package com.SWEProject;

import com.SWEProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainController
{

    public static void main(String [] args)
    {
        SpringApplication.run(MainController.class,args);
    }

}
