package com.caoshuai.back.repo;

import com.caoshuai.back.entity.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.name LIKE %?1%")
    Page<User> findByKeyword(String keyword, Pageable pageable);

    boolean existsByName(String username);

    boolean existsByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.name = ?1 or u.email = ?2 ")
    Optional<User> findByNameAndEmail(String name, String email);

}