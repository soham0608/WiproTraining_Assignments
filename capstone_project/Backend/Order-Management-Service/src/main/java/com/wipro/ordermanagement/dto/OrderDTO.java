package com.wipro.ordermanagement.dto;

import lombok.Data;
import java.util.List;

@Data
public class OrderDTO {
    private Integer oid;
    private Integer user_id;
    private String status;
    private List<OrderItemDTO> orderItems;
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<OrderItemDTO> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItemDTO> orderItems) {
		this.orderItems = orderItems;
	}
	public OrderDTO(Integer oid, Integer user_id, String status, List<OrderItemDTO> orderItems) {
		super();
		this.oid = oid;
		this.user_id = user_id;
		this.status = status;
		this.orderItems = orderItems;
	}
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
