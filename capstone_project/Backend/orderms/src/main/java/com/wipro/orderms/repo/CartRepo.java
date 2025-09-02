package com.wipro.orderms.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.orderms.entity.Cart;


@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {
	Optional<Cart> findByUserId(Integer userId);
    void deleteByUserId(Integer userId);
}