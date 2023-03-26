package com.caoshuai.back.service;

import com.caoshuai.back.entity.User;
import com.caoshuai.back.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;

    public User login(String usernameOrEmail, String password) {

        System.out.println(usernameOrEmail);
        System.out.println(password);

        Optional<User> userOpt = userRepository.findByNameAndEmail(usernameOrEmail, usernameOrEmail);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }
}
