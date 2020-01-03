package com.example.orderService.Resource;

import com.example.orderService.Model.CustomerOrder;
import com.example.orderService.Model.Order;
import com.example.orderService.Model.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/orders")
public class OrderResource {

    private Map<Integer, List<Order>> customerOrdersMap = new ConcurrentHashMap<>();
    private Map<Integer, List<Product>> productsMap = new ConcurrentHashMap<>();

    private List<Order> buildCustomerOrdersList(int id){
        Map<Integer, List<Order>> customerOrders = buildOrdersMap();
        return customerOrders.getOrDefault(id, new ArrayList<>());
    }

    private Map<Integer, List<Order>> buildOrdersMap(){
        buildProductsMap();
        int[] orderIds = {1234, 1235};
        List<Product> productListOne = productsMap.get(orderIds[0]);
        List<Product> productListTwo = productsMap.get(orderIds[1]);
        customerOrdersMap.put(1, Arrays.asList(
                new Order(1234,productListOne, LocalDateTime.now(), productListOne.stream().mapToDouble(Product::getProdPrice).sum())));
        customerOrdersMap.put(2, Arrays.asList(
                new Order(1235, productListTwo, LocalDateTime.of(2019, 10, 12, 12, 12, 12, 12),
                        productListTwo.stream().mapToDouble(Product::getProdPrice).sum())));
        return customerOrdersMap;
    }

    private Map<Integer, List<Product>> buildProductsMap(){
        productsMap.put(1234, Arrays.asList(new Product(122, "toothpaste", "used to clean teeth", 10.50),
                new Product(123, "dove body wash", "to clean body", 5.50)));
        productsMap.put(1235, Arrays.asList(new Product(123, "baby shampoo", "to clean baby hair", 5.40),
                new Product(122, "toothpaste", "used to clean teeth", 10.50)));
        return productsMap;
    }

    @RequestMapping("/{customerId}")
    public CustomerOrder getCustomerOrders(@PathVariable int customerId){
        List<Order> customerOrdersList = buildCustomerOrdersList(customerId);
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setOrderList(customerOrdersList);
        return customerOrder;
    }
}
