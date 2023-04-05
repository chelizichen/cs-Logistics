package com.caoshuai.back.entity;

import org.hibernate.type.descriptor.sql.VarcharTypeDescriptor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "order_info_id")
    private Long orderInfoId;


    @Column(name = "order_desc")
    private String desc;

    @Column(name = "order_status")
    private String orderStatus;



    @Column(name = "finish_date")
    private String finishDate;


    @OneToMany(targetEntity = Logistics.class,cascade=CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<Logistics> logisticsList = new ArrayList<>();

    @OneToMany(targetEntity = Warehouse.class,cascade=CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<Warehouse> warehouseList = new ArrayList<>();

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDateTime finishDate) {
        final String s = finishDate.toString();
        this.finishDate = s;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    public List<Logistics> getLogisticsList() {
        return logisticsList;
    }

    public void setLogisticsList(List<Logistics> logisticsList) {
        this.logisticsList = logisticsList;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public List<Warehouse> getWarehouseList() {
        return warehouseList;
    }

    public void setWarehouseList(List<Warehouse> warehouseList) {
        this.warehouseList = warehouseList;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    // getters and setters
}
