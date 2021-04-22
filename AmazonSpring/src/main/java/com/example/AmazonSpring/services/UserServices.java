package com.example.AmazonSpring.services;

import com.example.AmazonSpring.models.User;
import com.example.AmazonSpring.models.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepo repo;

    public void insertUser(User user)
    {
        repo.insert(user);
    }

    public List<User> getAllUsers()
    {
        return repo.findAll();
    }

    public void removeUser(String id)
    {
        repo.deleteById(id);
    }

    public Optional<User> getAUser(String id)
    {
        return repo.findById(id);
    }

    public User loginUserByEmail(String email)
    {
        return repo.getByEmail(email);
    }
}
