package com.wipro.orderms.service;
import java.util.List;
import com.wipro.orderms.entity.Order;

public interface OrderService {
	
	Order createOrder(int userId); 
	public Order cancelOrder(int orderId);
	List<Order> getUserOrders(int userId);
	Order getOrderById(int orderId);
	List<Order> getAllOrders();
	Order updateOrderStatus(Integer orderId, String status);
}
