package com.caoshuai.back.service;

import com.caoshuai.back.entity.OrderInfo;
import com.caoshuai.back.repo.OrderInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderInfoService {

    @Autowired
    private OrderInfoRepository orderInfoRepository;

    public OrderInfo createOrderInfo(OrderInfo orderInfo) {
        return orderInfoRepository.save(orderInfo);
    }

    public OrderInfo getOrderInfoById(Long id) {
        return orderInfoRepository.findById(id).orElse(null);
    }

    public OrderInfo updateOrderInfo(Long id, OrderInfo orderInfo) {
        OrderInfo existingOrderInfo = orderInfoRepository.findById(id).orElse(null);
        if (existingOrderInfo != null) {
            existingOrderInfo.setTradeName(orderInfo.getTradeName());
            existingOrderInfo.setTradeTotal(orderInfo.getTradeTotal());
            existingOrderInfo.setTradePer(orderInfo.getTradePer());
            existingOrderInfo.setOrderTotal(orderInfo.getOrderTotal());
            existingOrderInfo.setCustomerId(orderInfo.getCustomerId());
            return orderInfoRepository.save(existingOrderInfo);
        }
        return null;
    }

    public void deleteOrderInfo(Long id) {
        orderInfoRepository.deleteById(id);
    }
}