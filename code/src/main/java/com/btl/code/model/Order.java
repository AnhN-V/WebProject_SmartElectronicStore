package com.btl.code.model;

import java.util.Date;

public class Order {

    private int id;

    private Date orderTime;

    private String status;

    private int total;

    private int userId;

    public Order(int id,
                 Date orderTime,
                 String status,
                 int total,
                 int userId) {
        this.id = id;
        this.orderTime = orderTime;
        this.status = status;
        this.total = total;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public String getStatus() {
        return status;
    }

    public int getTotal() {
        return total;
    }

    public int getUserId() {
        return userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderTime=" + orderTime +
                ", status='" + status + '\'' +
                ", total=" + total +
                ", userId=" + userId +
                '}';
    }
}
