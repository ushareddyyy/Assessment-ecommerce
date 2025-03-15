package com.ecommerce.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.CartItem;
import com.ecommerce.entity.User;
@Repository
public interface CartItemRepo extends JpaRepository<CartItem, Integer> {
	List<CartItem> findByUser(User user);
	void deleteByUser(User user);
}
