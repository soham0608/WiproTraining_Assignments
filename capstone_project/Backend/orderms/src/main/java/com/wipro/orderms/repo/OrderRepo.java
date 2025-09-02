package com.wipro.orderms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.orderms.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
	List<Order> findByUserId(Integer userId);
    List<Order> findByOrderStatus(String orderStatus);
}