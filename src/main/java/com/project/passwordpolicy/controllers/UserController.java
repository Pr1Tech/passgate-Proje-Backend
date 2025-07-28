package com.project.passwordpolicy.controllers;

import com.project.passwordpolicy.repos.UserRepository;
import org.springframework.web.bind.annotation.*;
import com.project.passwordpolicy.entities.User;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private  UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }
    
    @PostMapping
    public User createUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }
    
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable("userId") Long userId, @RequestBody User newUser) {

        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            User oldUser = user.get();
            oldUser.setUserName(newUser.getUserName());
            oldUser.setPassword(newUser.getPassword());
            userRepository.save(oldUser);
            return oldUser;
        }else  {
            return null;
        }

    }
    @DeleteMapping("/{userId}")
    public void deleteOneUser(@PathVariable("userId") Long userId) {
        userRepository.deleteById(userId);
    }
}
