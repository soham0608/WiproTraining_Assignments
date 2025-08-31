package com.wipro.ordermanagement.service;

import com.wipro.ordermanagement.dto.OrderItemDTO;
import java.util.List;

public interface OrderItemService {
	
    OrderItemDTO createOrderItem(OrderItemDTO orderItemDTO);
    List<OrderItemDTO> getItemsByOrder(Integer orderId);
    void deleteOrderItem(Integer itemId);
}
