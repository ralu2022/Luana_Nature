/*package com.example.Luana_Nature.controller;

import com.example.Luana_Nature.model.Order;
import com.example.Luana_Nature.model.dto.OrderDto;
import com.example.Luana_Nature.repository.OrderRepository;
import com.example.Luana_Nature.service.OrderService;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;


import java.util.List;

@Controller
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;


    @GetMapping
    public String getOrders(Model model){
        List<OrderDto> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        return "orders/order";
    }


    @GetMapping("/status/{orderStatus}")
    public String getOrdersBySettingStatus(@PathVariable String orderStatus, Model model){
        List<OrderDto> orders = orderService.getAllOrdersByStatus(orderStatus);
        model.addAttribute("orders", orders);
        return "orders/order";
    }

    @GetMapping("/new")
    public String createOrderForm(Model model){
        OrderDto orderDto = new OrderDto();
        model.addAttribute("order", orderDto);
        return "orders/create-order";
    }

    @PostMapping
    public String createOrder(@ModelAttribute("order") OrderDto orderDto){
        orderService.createOrder(orderDto);
        return "redirect:/orders";
    }

    @GetMapping("/{orderId}/edit")
    public String editOrderForm(@PathVariable("orderId") Long orderId , Model model) {

        Order order = orderService.getOrderById(orderId);

        model.addAttribute("order", order);

        return "orders/edit-order";
    }

    @PostMapping("/{orderId}")
    public String updateOrder(@PathVariable Long orderId,
                              @ModelAttribute("order") OrderDto order){
        orderService.updateOrder(order);
        return "redirect:/orders";
    }

    @GetMapping("/{orderId}/delete")
    public String deleteOrder(@PathVariable("orderId")Long orderId) {
        orderService.deleteOrder(orderId);
        return "redirect:/orders";
    }

    @GetMapping("/{orderId}/view")
    public String viewOrder(@PathVariable("orderId")Long orderId, Model model) {

        Order orderToView = orderService.getOrderById(orderId);
        model.addAttribute("order", orderToView);

        return "orders/view-order";
    }
}

*/
