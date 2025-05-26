package com.velazco.velazco_back.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.velazco.velazco_back.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Page<Order> findByStatus(Order.OrderStatus status, Pageable pageable);

}