package com.caoshuai.back.repo;

import com.caoshuai.back.entity.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.name LIKE %?1%")
    Page<User> findByKeyword(String keyword, Pageable pageable);
}