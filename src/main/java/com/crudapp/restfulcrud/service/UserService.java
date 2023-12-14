package com.crudapp.restfulcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudapp.restfulcrud.model.User;
import com.crudapp.restfulcrud.repository.UserRepository;

/*
 * Methods to use for the controller
 * 
 * 
*/

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    public List<User> showAll() {
        return userRepo.findAll();
    }

}
