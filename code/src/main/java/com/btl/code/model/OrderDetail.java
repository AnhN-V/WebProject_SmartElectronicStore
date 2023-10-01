package com.btl.code.model;

public class OrderDetail {

    private int id;

    private int orderId;

    private String productName;

    public OrderDetail(int id, int orderId, String productName) {
        this.id = id;
        this.orderId = orderId;
        this.productName = productName;
    }

    public int getId() {
        return id;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setProductId(String productName) {
        this.productName = productName;
    }
}
