package com.caoshuai.back.controller;

import com.caoshuai.back.dto.Pagination;
import com.caoshuai.back.dto.Ret;
import com.caoshuai.back.entity.User;
import com.caoshuai.back.service.LoginService;
import com.caoshuai.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

        @Autowired
        private UserService userService;

        @Autowired
        private LoginService loginService;

        @PostMapping
        public User createUser(@RequestBody User user) {
            return userService.createUser(user);
        }

        @PutMapping("/{id}")
        public User updateUser(@PathVariable Long id, @RequestBody User user) {
            return userService.updateUser(id, user);
        }

        @DeleteMapping("/{id}")
        public Ret deleteUser(@PathVariable Long id) {
            userService.deleteUser(id);
            return Ret.success(0);
        }

        @GetMapping("/{id}")
        public User getUser(@PathVariable Long id) {
            return userService.getUser(id);
        }

        @GetMapping
        public Ret getAllUsers(@RequestParam(value = "keyword",defaultValue = "")String keyword,
                               @RequestParam(value = "page",defaultValue = "1") String page,
                               @RequestParam(value = "size",defaultValue = "10")String size) {
            Integer _page = Integer.parseInt(page) - 1;
            Integer _size = Integer.valueOf(size);
            return Ret.success(userService.getAllUsers(keyword,_page,_size));
        }

        @PostMapping("/login")
        public Ret Login(@RequestBody User user){
            return Ret.success(loginService.login(user.getEmail(),user.getPassword()));
        }


}
