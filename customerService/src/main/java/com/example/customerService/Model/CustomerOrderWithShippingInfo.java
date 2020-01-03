package com.example.customerService.Model;

public class CustomerOrderWithShippingInfo {

    private Order order;
    private ShippingStatus shippingStatus;

    public CustomerOrderWithShippingInfo(){

    }

    public CustomerOrderWithShippingInfo(Order order, ShippingStatus shippingStatus) {
        this.order = order;
        this.shippingStatus = shippingStatus;
    }

    public Order getOrder() {
        return order;
    }

    public ShippingStatus getShippingStatus() {
        return shippingStatus;
    }
}
