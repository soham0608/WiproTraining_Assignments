package com.wipro.ordermanagement.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Entity
@Table(name = "orders")
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer oid;

    @Column(name = "user_id", nullable = false)
    private Integer user_id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.CREATED;

    @Column(name = "created_at", updatable = false, insertable = false)
    private LocalDateTime created_at;

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

	public Order(Integer oid, Integer user_id, Status status, LocalDateTime created_at) {
		super();
		this.oid = oid;
		this.user_id = user_id;
		this.status = status;
		this.created_at = created_at;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

}

