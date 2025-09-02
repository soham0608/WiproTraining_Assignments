package com.wipro.productms.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.productms.dto.Order;
import com.wipro.productms.entity.Product;
import com.wipro.productms.repo.ProductRepo;
import com.wipro.productms.util.AppConstant;

@Service
public class OrderEventConsumer {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;

    @KafkaListener(topics = AppConstant.INCOMING_TOPIC_NAME, groupId = "product_service")
    public void consumeOrderEvent(Order order) {
        System.out.println("Received Order event: " + order);

        boolean success = true;
        for (Map.Entry<Integer, Integer> entry : order.getProductQuantityMap().entrySet()) {
            int productId = entry.getKey();
            int qty = entry.getValue();

            Product product = productRepo.findById(productId).orElse(null);
            if (product == null || product.getAvailableQty() < qty) {
                success = false;
                break;
            }
            product.setAvailableQty(product.getAvailableQty() - qty);
            productRepo.save(product);
        }

        // send back result
        if (success) {
            order.setOrderStatus("CONFIRMED");
        } else {
            order.setOrderStatus("FAILED");
        }

        kafkaTemplate.send(AppConstant.OUTGOING_TOPIC_NAME, order);
    }
}