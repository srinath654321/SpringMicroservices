package com.example.shippingService.resource;

import com.example.shippingService.model.ShippingStatus;
import com.example.shippingService.model.ShippingType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/shipping")
public class ShippingResource {

    Map<Integer, ShippingStatus> shippingStatusMap = new ConcurrentHashMap<>();

    private void buildShippingStatuses() {
        shippingStatusMap.put(1234, ShippingStatus.NOT_DELIVERED);
        shippingStatusMap.put(1235, ShippingStatus.DELIVERD);
    }

    @RequestMapping("/{orderId}")
    public ShippingStatus getShippingStatus(@PathVariable int orderId){
        buildShippingStatuses();
        return shippingStatusMap.getOrDefault(orderId, ShippingStatus.NOT_FOUND);

    }
}
