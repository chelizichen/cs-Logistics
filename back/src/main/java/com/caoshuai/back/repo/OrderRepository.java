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

    // 根据名称模糊查询订单
    @Query("SELECT o FROM Order o,User u  WHERE u.name LIKE %?1% and u.id = o.customerId")
    Page<Order> findByKeyword(String keyword, Pageable pageable);

    @Query("SELECT o FROM Order o,User u  WHERE u.name LIKE %?1% and u.id = o.customerId and o.orderStatus = '0' ")
    Page<Order> findBackByKeyword(String keyword, Pageable pageable);

    // 根据Id查询所有记录
    @Query("SELECT o FROM Order o,Logistics l,Warehouse  w WHERE o.id = ?1 ")
    Order findAllByOrderId(Long id);

    // 根据UserId 查询所有记录
    @Query("SELECT o,u FROM Order o,User u where o.customerId = ?1 and o.customerId = u.id ")
    List<Order> findAllByUserId(Long id);

    @Query("SELECT count (o) as total FROM Order o where o.orderStatus = '0' ")
    List getBackTotal();

    @Query("SELECT count (o) as total FROM Order o")
    List getTotal();
}
