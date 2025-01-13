package com.example.Luana_Nature.repository;

import com.example.Luana_Nature.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

