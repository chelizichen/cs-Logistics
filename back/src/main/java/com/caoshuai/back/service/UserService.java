package com.caoshuai.back.service;

import com.caoshuai.back.dto.ListRet;
import com.caoshuai.back.entity.User;
import com.caoshuai.back.expection.ResourceNotFoundException;
import com.caoshuai.back.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        Optional<User> userOpt = userRepository.findByNameAndEmail(user.getName(), user.getEmail());
        if(!userOpt.isPresent()){
            return userRepository.save(user);
        }else {
            return null;
        }
    }

    public User updateUser(Long id, User user) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        existingUser.setName(user.getName());
        existingUser.setAddress(user.getAddress());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setPermissions(user.getPermissions());
        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }

    public ListRet getAllUsers(String keyword,Integer page,Integer size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<User> byKeyword = userRepository.findByKeyword(keyword, pageable);
        List<User> content = byKeyword.getContent();
        long totalElements = byKeyword.getTotalElements();
        ListRet listRet = new ListRet(content, totalElements);
        return listRet;
    }



}
