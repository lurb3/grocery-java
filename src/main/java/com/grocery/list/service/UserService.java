package com.grocery.list.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.list.exception.UserNotFoundException;
import com.grocery.list.model.User;
import com.grocery.list.repo.UserRepo;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user) {
        user.setUsername("Jacob");
        user.setEmail("Jacob@email.com");
        user.setPassword("123456");
        return userRepo.save(user);
    }

    public List<User> findUsers() {
        return userRepo.findAll();
    }

    public User updateUser(User user) {
        return userRepo.save(user);
    }

    public User findUserById(Long id) {
        return userRepo.findUserById(id)
            .orElseThrow(() -> new UserNotFoundException("User with id " + id + " was not found."));
    }

    public void deleteUser(Long id) {
        userRepo.deleteUserById(id);
    }
}
