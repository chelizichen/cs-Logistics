package com.caoshuai.back.controller;

import com.caoshuai.back.dto.ListRet;
import com.caoshuai.back.dto.Ret;
import com.caoshuai.back.entity.Order;
import com.caoshuai.back.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public Ret getAllOrders(@RequestParam(value = "keyword",defaultValue = "")String keyword,
                                    @RequestParam(value = "page",defaultValue = "1") String page,
                                    @RequestParam(value = "size",defaultValue = "10")String size) {
        Integer _page = Integer.parseInt(page) - 1;
        Integer _size = Integer.valueOf(size);
        Pageable pageable = PageRequest.of(_page, _size);
        Page<Order> byKeyword = orderRepository.findByKeyword(keyword, pageable);
        ListRet listRet = new ListRet(byKeyword.getContent(), byKeyword.getTotalElements());
        return Ret.success(listRet);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(order, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order savedOrder = orderRepository.save(order);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order order) {
        Order existingOrder = orderRepository.findById(id).orElse(null);
        if (existingOrder == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            existingOrder.setCustomerId(order.getCustomerId());
            existingOrder.setOrderDate(order.getOrderDate());
            existingOrder.setTotal(order.getTotal());
            Order savedOrder = orderRepository.save(existingOrder);
            return new ResponseEntity<>(savedOrder, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/between")
    public List<Order> getOrdersBetweenDates(@RequestParam("start") Date start, @RequestParam("end") Date end) {
        return orderRepository.findByOrderDateBetween(start, end);
    }
}
