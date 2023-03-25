package com.caoshuai.back.repo;

import com.caoshuai.back.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}