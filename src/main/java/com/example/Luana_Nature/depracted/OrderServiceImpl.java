/*package com.example.Luana_Nature.service;


import com.example.Luana_Nature.model.Order;
import com.example.Luana_Nature.model.dto.OrderDto;
import com.example.Luana_Nature.model.dto.OrderMapper;
import com.example.Luana_Nature.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Override
    public void createOrder(OrderDto orderDto) {

        Order order = OrderMapper.mapToObject(orderDto);
        orderRepository.save(order);
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<OrderDto> orderList = orderRepository
                .findAll()
                .stream()
                .map(OrderMapper::mapToDto)
                .toList();
        return orderList;
    }



    @Override
    public List<OrderDto> getAllOrdersByStatus(String orderStatus) {
        List<OrderDto> orderList = orderRepository
                .findAllById(orderStatus)
                .stream()
                .map(OrderMapper::mapToDto)
                .toList();
        return orderList;
    }


    @Override
    public Order getOrderById(Long id) {

        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order with id: " + id + " doesn't exists."));
        return order;
    }
    @Override
    public void updateOrder(OrderDto orderDto) {
        Order order = getOrderById(orderDto.getOrderId());
        order.setCustomerName(orderDto.getCustomerName());
        order.setTotalAmount(orderDto.getTotalAmount());
        order.setCreationDate(orderDto.getCreationDate());
        order.setOrderStatus(orderDto.getOrderStatus());
        order.setAddress(orderDto.getAddress());
        order.setNotes(orderDto.getNotes());
        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
*/