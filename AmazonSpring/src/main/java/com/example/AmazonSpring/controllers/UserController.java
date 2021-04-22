package com.example.AmazonSpring.controllers;

import com.example.AmazonSpring.Response;
import com.example.AmazonSpring.models.User;
import com.example.AmazonSpring.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping("/users/all")
    public ResponseEntity getUsers()
    {
        var response = new Response(userServices.getAllUsers(),"All Users");
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PostMapping(value = "/users/registration",consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity registerAUser(@RequestBody User user)
    {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        userServices.insertUser(user);
        return new ResponseEntity(user,HttpStatus.OK);
    }

    @PostMapping(value = "/users/login", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity signInUser(@RequestBody User user)
    {
        var response = userServices.loginUserByEmail(user.getEmail());
        if(BCrypt.checkpw(user.getPassword(), response.getPassword()))
        {
            return new ResponseEntity(response, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity("Invalid Login Credentials", HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity deleteAUser(@PathVariable("id") String id)
    {
        userServices.removeUser(id);

        return new ResponseEntity(HttpStatus.OK);
    }
}
