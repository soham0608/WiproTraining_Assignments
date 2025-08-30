package com.wipro.ordermanagement.service;

import com.wipro.ordermanagement.dto.OrderDTO;

import java.util.List;

public interface OrderService {
	
    OrderDTO createOrder(Integer userId);
    
    OrderDTO cancelOrder(Integer orderId);
    
    List<OrderDTO> getAllOrders();
    
    List<OrderDTO> getOrdersByUser(Integer userId);
    
    OrderDTO getOrderById(Integer orderId);
}
