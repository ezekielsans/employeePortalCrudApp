package com.crudapp.restfulcrud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crudapp.restfulcrud.model.User;
import com.crudapp.restfulcrud.repository.UserRepository;
import com.crudapp.restfulcrud.service.UserService;

@Controller
public class UserController {

    // call the repository object
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private UserService service;

    @GetMapping("/")
    public String showHomepage(Model model) {
        List<User> usersList = service.showAll();
        // call repo and then call the crud method from jpaRepository
        model.addAttribute("usersList", usersList);
        return "index";
    }

    @GetMapping("/getUsers")
    // return all
    public String getAllUsers(Model model) {

        List<User> usersList = service.showAll();
        // call repo and then call the crud method from jpaRepository
        model.addAttribute("usersList", usersList);

        // try {
        // instantiate the Model
        // List<User> usersList = new ArrayList<>();
        // call repo and then call the crud method from jpaRepository
        // userRepo.findAll().forEach(usersList::add);

        // if (usersList.isEmpty()) {
        return "userTable";
        // }
        // return the list
        // return new ResponseEntity<>(usersList, HttpStatus.OK);

        // } catch (Exception e) {
        // send error message
        // return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // }

    @GetMapping("/getUserBy/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {

        Optional<User> userData = userRepo.findById(id);
        if (userData.isPresent()) {
            // return the userData
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        }
        // return error message
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/createUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User userObj = userRepo.save(user);
        // object,status
        return new ResponseEntity<>(userObj, HttpStatus.OK);
    }

    @PostMapping("/updateUserBy/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable Integer id, @RequestBody User newUserData) {
        Optional<User> oldUserData = userRepo.findById(id);
        if (oldUserData.isPresent()) {

            User updateUserData = oldUserData.get();
            updateUserData.setFirst_name(newUserData.getFirst_name());
            updateUserData.setLast_name(newUserData.getLast_name());
            updateUserData.setEmail(newUserData.getEmail());
            updateUserData.setPassword(newUserData.getPassword());
            updateUserData.setPhonenumber(newUserData.getPhonenumber());

            User userObj = userRepo.save(updateUserData);
            return new ResponseEntity<>(userObj, HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // @PostMapping
    // public void updateUserById() {
    // }

    // @DeleteMapping
    // public void deleteUser() {
    // }

    @DeleteMapping("/deleteBookBy/{id}")
    public ResponseEntity<HttpStatus> deleteUserById(@PathVariable Integer id) {
        userRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
