package com.example.Luana_Nature.repository;

import com.example.Luana_Nature.model.Order;
import com.example.Luana_Nature.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findById(Long orderId);
    List<Order> findByOrderUser(User orderUser);
}
