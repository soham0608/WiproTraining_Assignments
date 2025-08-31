package com.wipro.ordermanagement.kafka;

import lombok.Data;
import java.util.List;

@Data
public class OrderCreatedEvent {
    private Integer order_id;
    private Integer user_id;
    private List<OrderItemPayload> items;
    
    
    public Integer getOrder_id() {
		return order_id;
	}


	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}


	public Integer getUser_id() {
		return user_id;
	}


	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}


	public List<OrderItemPayload> getItems() {
		return items;
	}


	public void setItems(List<OrderItemPayload> items) {
		this.items = items;
	}


	@Data
    public static class OrderItemPayload {
        private Integer product_id;
        private String product_name;
        private Integer quantity;
        private Double price;
		public Integer getProduct_id() {
			return product_id;
		}
		public void setProduct_id(Integer product_id) {
			this.product_id = product_id;
		}
		public String getProduct_name() {
			return product_name;
		}
		public void setProduct_name(String product_name) {
			this.product_name = product_name;
		}
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
        
        
    }
}
