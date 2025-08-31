package com.wipro.ordermanagement.repository;

import com.wipro.ordermanagement.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    List<OrderItem> findByOrder_Oid(Integer orderId);
}
