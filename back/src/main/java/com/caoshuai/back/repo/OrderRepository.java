package com.caoshuai.back.repo;

import com.caoshuai.back.entity.Order;
import com.caoshuai.back.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByOrderDateBetween(Date start, Date end);

    @Query("SELECT o FROM Order o,User u  WHERE u.name LIKE %?1% and u.id = o.customerId")
    Page<Order> findByKeyword(String keyword, Pageable pageable);

}