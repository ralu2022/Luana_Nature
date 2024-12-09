package com.example.Luana_Nature.service;


import com.example.Luana_Nature.model.Order;
import com.example.Luana_Nature.model.Product;
import com.example.Luana_Nature.model.User;
import com.example.Luana_Nature.repository.OrderRepository;
import com.example.Luana_Nature.repository.ProductRepository;
import com.example.Luana_Nature.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void addOrder(LocalDate orderDate, String status,User orderUser, Product product) {
        Order order = new Order();
        order.setOrderDate(orderDate);
        order.setStatus(status);
        order.setOrderUser(orderUser);
        order.setProduct(product);
        orderRepository.save(order);
    }
}
