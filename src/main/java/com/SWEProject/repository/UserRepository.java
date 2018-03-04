package com.SWEProject.repository;


import com.SWEProject.Entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String>{

}