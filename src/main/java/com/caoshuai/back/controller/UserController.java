package com.caoshuai.back.controller;

import com.caoshuai.back.entity.User;
import com.caoshuai.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

        @Autowired
        private UserService userService;

        @PostMapping
        public User createUser(@RequestBody User user) {
            return userService.createUser(user);
        }

        @PutMapping("/{id}")
        public User updateUser(@PathVariable Long id, @RequestBody User user) {
            return userService.updateUser(id, user);
        }

        @DeleteMapping("/{id}")
        public void deleteUser(@PathVariable Long id) {
            userService.deleteUser(id);
        }

        @GetMapping("/{id}")
        public User getUser(@PathVariable Long id) {
            return userService.getUser(id);
        }

        @GetMapping
        public List<User> getAllUsers() {
            return userService.getAllUsers();
        }

}
