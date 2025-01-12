/*package com.example.Luana_Nature.util.notinuse.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor

public class OrderController {

    private final OrderService orderService;
    private final OrderRepository orderRepository;

    @GetMapping("/orders")
    public String listAllOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "orders";
    }


    @GetMapping("/addProduct") // Create a new order
    public String createNewOrder(Model model) {
        Order newOrder = orderService.createOrder(LocalDate.now(), "Pending", 0.0);
        Long orderId = newOrder.getOrderId();
        model.addAttribute("orderId", orderId);
        model.addAttribute("allproducts", orderService.getAvailableProducts());
        return "store";
    }

    @GetMapping("/{orderId}/addProduct") // Add products to an existing order
    public String addToExistingOrder(@PathVariable Long orderId, Model model) {
        orderService.getOrderById(orderId);
        model.addAttribute("orderId", orderId);
        model.addAttribute("allproducts", orderService.getAvailableProducts());
        return "store";
    }

    @PostMapping("/{orderId}/addProduct/{productId}")
    public String addProductToOrder(@PathVariable Long orderId, @PathVariable Long productId) {
        orderService.addProductToOrder(orderId, productId);
        return "redirect:/orders/orders";
    }

    @GetMapping("/{orderId}")
    public String visualizeOrder(@PathVariable Long orderId, Model model) {
        Order order = orderService.getOrderById(orderId);
        model.addAttribute("order", order);
        return "order";
    }

}*/
