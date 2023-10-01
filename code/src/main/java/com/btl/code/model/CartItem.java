package com.btl.code.model;

public class CartItem {

    private int id;

    private int quantity;

    private int userId;

    private int productId;

    public CartItem(int id, int quantity, int userId, int productId) {
        this.id = id;
        this.quantity = quantity;
        this.userId = userId;
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getUserId() {
        return userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
