package com.caoshuai.back.service;

import com.caoshuai.back.entity.User;
import com.caoshuai.back.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User register(String username, String password, String email) {
        if (userRepository.existsByName(username)) {
            throw new RuntimeException("用户名已存在");
        }
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("邮箱已存在");
        }
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        user.setEmail(email);
        userRepository.save(user);
        return user;
    }
}
