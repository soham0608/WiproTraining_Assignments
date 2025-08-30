package com.wipro.ordermanagement.service.impl;

import com.wipro.ordermanagement.dto.OrderDTO;
import com.wipro.ordermanagement.entity.Order;
import com.wipro.ordermanagement.repository.OrderRepository;
import com.wipro.ordermanagement.service.OrderService;

import jakarta.ws.rs.NotFoundException;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDTO createOrder(Integer userId) {
        Order order = new Order();
        order.setUser_id(userId);
        order.setStatus(Order.Status.CREATED);  

        Order savedOrder = orderRepository.save(order);
        return mapToDTO(savedOrder);
    }

    @Override
    public OrderDTO cancelOrder(Integer orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("Order not found with id: " + orderId));

        order.setStatus(Order.Status.CANCELLED);  
        Order updatedOrder = orderRepository.save(order);

        return mapToDTO(updatedOrder);
    }


    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrdersByUser(Integer userId) {
        return orderRepository.findByUserId(userId)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderById(Integer orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("Order not found with id: " + orderId));
        return mapToDTO(order);
    }

    private OrderDTO mapToDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setOid(order.getOid());
        dto.setUser_id(order.getUser_id());
        dto.setStatus(order.getStatus().name()); 
        dto.setCreated_at(order.getCreated_at());
        return dto;
    }
}
