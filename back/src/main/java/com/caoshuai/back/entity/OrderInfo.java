package com.caoshuai.back.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "order_info")
public class OrderInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "trade_name")
    private String tradeName;

    @Column(name = "trade_total")
    private String tradeTotal;

    @Column(name = "trade_per")
    private BigDecimal tradePer;

    @Column(name = "order_total")
    private String orderTotal;

    @Column(name = "customer_id")
    private Long customerId;

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getTradeTotal() {
        return tradeTotal;
    }

    public void setTradeTotal(String tradeTotal) {
        this.tradeTotal = tradeTotal;
    }

    public BigDecimal getTradePer() {
        return tradePer;
    }

    public void setTradePer(BigDecimal tradePer) {
        this.tradePer = tradePer;
    }

    public String getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(String orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }




}
