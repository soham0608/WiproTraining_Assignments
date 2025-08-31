package com.wipro.productmanagement.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductDTO {
	
	private Integer pid;

    @JsonProperty("product_name")
    @NotBlank(message = "product_name is required")
    @Size(max = 100, message = "product_name must be <= 100 chars")
    private String productName;

    @Size(max = 500, message = "description must be <= 500 chars")
    private String description;

    @NotNull(message = "price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "price must be > 0")
    private BigDecimal  price;

    @NotNull(message = "quantity is required")
    @Min(value = 0, message = "quantity must be >= 0")
    private Integer quantity;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public ProductDTO(Integer pid,
			@NotBlank(message = "product_name is required") @Size(max = 100, message = "product_name must be <= 100 chars") String productName,
			@Size(max = 500, message = "description must be <= 500 chars") String description,
			@NotNull(message = "price is required") @DecimalMin(value = "0.0", inclusive = false, message = "price must be > 0") BigDecimal price,
			@NotNull(message = "quantity is required") @Min(value = 0, message = "quantity must be >= 0") Integer quantity) {
		super();
		this.pid = pid;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	
}
