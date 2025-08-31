package com.wipro.ordermanagement.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer oid;

    @Column(name = "user_id", nullable = false)
    private Integer user_id;

    @Enumerated(EnumType.STRING)
    private Status status = Status.CREATED;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime created_at = LocalDateTime.now();

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    public enum Status {
        CREATED,
        CANCELLED
    }

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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Order(Integer oid, Integer user_id, Status status, LocalDateTime created_at, List<OrderItem> orderItems) {
		super();
		this.oid = oid;
		this.user_id = user_id;
		this.status = status;
		this.created_at = created_at;
		this.orderItems = orderItems;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
