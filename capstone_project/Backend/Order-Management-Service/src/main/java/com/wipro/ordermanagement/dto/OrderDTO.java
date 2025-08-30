package com.wipro.ordermanagement.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
public class OrderDTO {

    private Integer oid;

    @NotNull(message = "User ID cannot be null")
    private Integer user_id;

    private String status;

    private LocalDateTime created_at;

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

	public void setStatus(String string) {
		this.status = string;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public OrderDTO(Integer oid, @NotNull(message = "User ID cannot be null") Integer user_id, String status,
			LocalDateTime created_at) {
		super();
		this.oid = oid;
		this.user_id = user_id;
		this.status = status;
		this.created_at = created_at;
	}

	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
