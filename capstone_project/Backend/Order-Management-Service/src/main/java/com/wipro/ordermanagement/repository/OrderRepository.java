package com.wipro.ordermanagement.repository;

import com.wipro.ordermanagement.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	
    List<Order> findByUserId(Integer userId);
}
