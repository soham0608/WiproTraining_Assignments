package com.wipro.ordermanagement.kafka;

import java.util.List;

public class OrderCancelledEvent {
    private Integer orderId;
    private Integer userId;
    private List<OrderItemPayload> items;

    // Getters & Setters
    public Integer getOrderId() { return orderId; }
    public void setOrderId(Integer orderId) { this.orderId = orderId; }
    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public List<OrderItemPayload> getItems() { return items; }
    public void setItems(List<OrderItemPayload> items) { this.items = items; }

    public static class OrderItemPayload {
        private Integer productId;
        private Integer quantity;

        // Getters & Setters
        public Integer getProductId() { return productId; }
        public void setProductId(Integer productId) { this.productId = productId; }
        public Integer getQuantity() { return quantity; }
        public void setQuantity(Integer quantity) { this.quantity = quantity; }
    }
}
