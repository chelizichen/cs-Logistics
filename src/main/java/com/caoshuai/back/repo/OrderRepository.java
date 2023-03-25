package com.caoshuai.back.repo;

import com.caoshuai.back.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByOrderDateBetween(Date start, Date end);
}