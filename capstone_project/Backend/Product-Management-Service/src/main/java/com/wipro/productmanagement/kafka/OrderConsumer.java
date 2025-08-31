package com.wipro.productmanagement.kafka;

import com.wipro.productmanagement.service.ProductService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private final ProductService productService;

    public OrderConsumer(ProductService productService) {
        this.productService = productService;
    }

    @KafkaListener(topics = "order-topic", groupId = "product-group")
    public void consumeOrderEvent(OrderCreatedEvent event) {
        boolean allSuccess = true;
        String message = "All products updated successfully";

        for (OrderCreatedEvent.OrderItemPayload item : event.getItems()) {
            // Check availability
            if (!productService.checkAvailability(item.getProduct_id(), item.getQuantity())) {
                allSuccess = false;
                message = "Product " + item.getProduct_id() + " insufficient stock";
                break;
            }
        }

        if (allSuccess) {
            // Reduce quantities
            for (OrderCreatedEvent.OrderItemPayload item : event.getItems()) {
                productService.reduceQuantity(item.getProduct_id(), item.getQuantity());
            }
        }

        // Optional: produce OrderProcessedEvent back to order-topic if needed
        // But can skip if trainer doesn’t require feedback
    }
}
