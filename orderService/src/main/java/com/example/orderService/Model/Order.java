package com.example.orderService.Model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private final int orderId;
    private final List<Product> product;
    private final LocalDateTime orderDate;
    private final Double orderTotal;

    public Order(int orderId, List<Product> product, LocalDateTime orderDate, Double orderTotal) {
        this.orderId = orderId;
        this.product = product;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
    }

    public int getOrderId() {
        return orderId;
    }

    public List<Product> getProduct() {
        return product;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }
}
