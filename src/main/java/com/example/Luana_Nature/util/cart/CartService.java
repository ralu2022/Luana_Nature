/*package com.example.Luana_Nature.service;

import com.example.Luana_Nature.util.Cart;
import com.example.Luana_Nature.model.Product;
import com.example.Luana_Nature.model.User;
import com.example.Luana_Nature.util.CartRepository;
import com.example.Luana_Nature.repository.ProductRepository;
import com.example.Luana_Nature.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public void addToCart(String username, Long productId, int quantity) {
        Optional<User> user = Optional.ofNullable(userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilizatorul nu a fost găsit!")));

        Optional<Product> product = Optional.ofNullable(productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Produsul nu a fost găsit!")));

        Cart cart = cartRepository.findByUserId(user.get().getId()).stream()
                .filter(c -> c.getProduct().equals(product))
                .findFirst()
                .orElse(new Cart());

        cart.setUser(user);
        cart.setProduct(product);
        cart.setQuantity(cart.getQuantity() + quantity);

        cartRepository.save(cart);
    }

    public List<Cart> getCartItems(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return cartRepository.findByUserId(user.getId());
    }

    public boolean itemExists(Long userId, Long productId) {
        return cartRepository.findByUser_IdAndProduct_Id(userId, productId) != null;
    }
}*/
