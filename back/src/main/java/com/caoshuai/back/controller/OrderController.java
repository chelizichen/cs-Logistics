package com.caoshuai.back.controller;

import com.caoshuai.back.dto.ListRet;
import com.caoshuai.back.dto.Ret;
import com.caoshuai.back.entity.Order;
import com.caoshuai.back.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

// 根据个人ID查询所有订单信息
// 根据订单查询所有物流信息
// 下单

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public Ret getAllOrders(@RequestParam(value = "keyword", defaultValue = "") String keyword,
                            @RequestParam(value = "page", defaultValue = "1") String page,
                            @RequestParam(value = "size", defaultValue = "10") String size) {
        Integer _page = Integer.parseInt(page) - 1;
        Integer _size = Integer.valueOf(size);
        Pageable pageable = PageRequest.of(_page, _size);
        Page<Order> byKeyword = orderRepository.findByKeyword(keyword, pageable);
        ListRet listRet = new ListRet(byKeyword.getContent(), byKeyword.getTotalElements());
        return Ret.success(listRet);
    }

    // 根据订单 查看所有物流信息
    @GetMapping("/{id}")
    public Ret getOrderById(@PathVariable Long id) {
        Order order = orderRepository.findAllByOrderId(id);
        if (order == null) {
            return Ret.success("none data");
        } else {
            return Ret.success(order);
        }
    }


    // 根据个人Id查看所有订单
    @GetMapping("/user/{id}")
    public Ret getOrderByUserId(@PathVariable Long id) {
        List<Order> order = orderRepository.findAllByUserId(id);
        if (order == null) {
            return Ret.success("none data");
        } else {
            return Ret.success(order);
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
            existingOrder.setOrderStatus(order.getOrderStatus());
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

    @GetMapping("/back")
    public Ret getBack(@RequestParam(value = "keyword", defaultValue = "") String keyword,
                       @RequestParam(value = "page", defaultValue = "1") String page,
                       @RequestParam(value = "size", defaultValue = "10") String size) {
        Integer _page = Integer.parseInt(page) - 1;
        Integer _size = Integer.valueOf(size);
        Pageable pageable = PageRequest.of(_page, _size);
        Page<Order> byKeyword = orderRepository.findBackByKeyword(keyword, pageable);
        ListRet listRet = new ListRet(byKeyword.getContent(), byKeyword.getTotalElements());
        return Ret.success(listRet);
    }

    @GetMapping("/analyze")
    public Ret getAnalyze(){
        final List total = orderRepository.getTotal();
        final List backTotal = orderRepository.getBackTotal();
        final HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("total",total);
        objectObjectHashMap.put("backTotal",backTotal);
        return Ret.success(objectObjectHashMap);
    }

    @GetMapping("/finish")
    public Ret Finish(@RequestParam("id") String id) {
        final Long aLong = Long.valueOf(id);
        Order existingOrder = orderRepository.findById(aLong).orElse(null);
        System.out.println(existingOrder);
        existingOrder.setOrderStatus("2");
        existingOrder.setFinishDate(LocalDateTime.now());
        orderRepository.save(existingOrder);
        return Ret.success(existingOrder);
    }
}
