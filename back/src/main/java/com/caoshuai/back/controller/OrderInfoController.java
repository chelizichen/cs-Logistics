package com.caoshuai.back.controller;

import com.caoshuai.back.dto.Ret;
import com.caoshuai.back.entity.OrderInfo;
import com.caoshuai.back.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderinfo")
public class OrderInfoController {

    @Autowired
    private OrderInfoService orderInfoService;

    @PostMapping("/orderinfo")
    public OrderInfo createOrderInfo(@RequestBody OrderInfo orderInfo) {
        return orderInfoService.createOrderInfo(orderInfo);
    }

    @GetMapping("/orderinfo/{id}")
    public OrderInfo getOrderInfoById(@PathVariable Long id) {
        return orderInfoService.getOrderInfoById(id);
    }

    @PutMapping("/orderinfo/{id}")
    public OrderInfo updateOrderInfo(@PathVariable Long id, @RequestBody OrderInfo orderInfo) {
        return orderInfoService.updateOrderInfo(id, orderInfo);
    }

    @DeleteMapping("/orderinfo/{id}")
    public Ret deleteOrderInfo(@PathVariable Long id) {
        orderInfoService.deleteOrderInfo(id);
        return Ret.success("");
    }
}