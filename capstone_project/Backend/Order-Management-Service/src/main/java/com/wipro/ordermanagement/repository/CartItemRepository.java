package com.wipro.ordermanagement.repository;

import com.wipro.ordermanagement.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    List<CartItem> findByUser_id(Integer userId);
}
