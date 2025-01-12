/*package com.example.Luana_Nature.util.notinuse.order;

import com.example.Luana_Nature.model.Product;
import com.example.Luana_Nature.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional
    public Order createOrder(LocalDate orderDate, String status, Double totalPrice) {
        Order order = new Order();
        order.setOrderDate(orderDate);
        order.setStatus(status);
        order.setTotalPrice(totalPrice);
        return orderRepository.save(order);
    }

    @Transactional
    public Order addProductToOrder(Long orderId, Long productId) {
     Order order;
        if (orderId == null || !orderRepository.existsById(orderId)) {
            order = createOrder(LocalDate.now(), "Pending", 0.0);
        } else {
            order = orderRepository.findById(orderId)
                    .orElseThrow(() -> new IllegalArgumentException("Comanda nu există"));
        }
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isEmpty()) {
            throw new IllegalArgumentException("Produsul nu exista!");
        }

        Product product = optionalProduct.get();
        order.getOrderProducts().add(product);

        double updatedTotalPrice = order.getTotalPrice() + product.getPrice();
        order.setTotalPrice(updatedTotalPrice);

        return orderRepository.save(order);

    }

    public List<Product> getAvailableProducts() {
        return productRepository.findAll();
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Comanda nu a fost găsită!"));
    }

}*/
