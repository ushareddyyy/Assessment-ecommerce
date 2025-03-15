package com.ecommerce.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.OrderItem;
@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem, Integer> {
}

