package com.example.customerService.Model;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.time.LocalDateTime;
import java.util.List;

public class Order {


    private int orderId;
    private List<Product> product;
    private LocalDateTime orderDate;
    private Double orderTotal;

    public Order(int orderId, List<Product> product, LocalDateTime orderDate, Double orderTotal) {
        this.orderId = orderId;
        this.product = product;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
    }

    public Order(){

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
