package com.wipro.orderms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.wipro.orderms.entity.Order;
import com.wipro.orderms.repo.OrderRepo;
import com.wipro.orderms.util.AppConstant;

@Service
public class ProductResponseConsumer {

    @Autowired
    OrderRepo orderRepo;

    @KafkaListener(topics = AppConstant.INCOMING_TOPIC_NAME, groupId = "order_service")
    public void consumeProductResponse(Order order) {
        System.out.println("Received Product response: " + order);
     // update status in DB
        Order dbOrder = orderRepo.findById(order.getOrderId()).orElse(null);
        if (dbOrder != null) {
            dbOrder.setOrderStatus(order.getOrderStatus());
            orderRepo.save(dbOrder);
        }
    }
}