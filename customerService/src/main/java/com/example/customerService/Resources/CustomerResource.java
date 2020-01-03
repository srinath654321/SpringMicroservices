package com.example.customerService.Resources;

import com.example.customerService.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customer")
public class CustomerResource {

    @Autowired
    private RestTemplate restTemplate;

    private List<Customer> buildCustomersData(){
        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer.CustomerBuilder().setName("srinath").setCustId(1).setAddress(new Address("200 E Roger Road", "Arizona", 85719, "Tucosn"))
        .setPaymentInfo( new PaymentInfo("1234 456 789", "047")).build());
        customerList.add(new Customer.CustomerBuilder().setCustId(2).setName("amandeep").setAddress(new Address("3035 E Campo Abiero", "Arizona", 85789, "Tucson"))
                .setPaymentInfo(new PaymentInfo("1285 4875 284 12", "455")).build());
        return customerList;
    }

    @RequestMapping("orders/{id}")
    public List<CustomerOrderWithShippingInfo> getCustomerOrders(@PathVariable int id){
        CustomerOrder customerOrder = restTemplate.getForObject("http://order-service/orders/" + id, CustomerOrder.class);
        List<Order> orderList = customerOrder.getOrderList();
        return orderList.stream().map(order -> {
            ShippingStatus shippingStatus = restTemplate.getForObject("http://shipping-service/shipping/"+ order.getOrderId(), ShippingStatus.class);
            return new CustomerOrderWithShippingInfo(order, shippingStatus);
        }).collect(Collectors.toList());
    }



    @RequestMapping("/")
    public List<Customer> getCustomersInfo(){
        return buildCustomersData();
    }

    @RequestMapping("/{id}")
    public Customer getCustomerInfo(@PathVariable int id){
        List<Customer> customerList = buildCustomersData();
        Optional<Customer> customer = customerList.stream().filter(cust -> cust.getCustId() == id).findFirst();
        if (customer.isPresent()) {
            return customer.get();
        }else {
            return new Customer.CustomerBuilder().setMessage("customer is not found").build();
        }
    }
}
