package com.wipro.productmanagement.exception;

public class InsufficientStockException extends RuntimeException {
	
    public InsufficientStockException(String message) 
    {
        super(message);
    }
}
