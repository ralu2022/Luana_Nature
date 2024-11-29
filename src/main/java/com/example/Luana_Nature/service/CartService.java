package com.example.Luana_Nature.service;

import com.example.Luana_Nature.model.Cart;
import com.example.Luana_Nature.model.Product;
import com.example.Luana_Nature.model.User;
import com.example.Luana_Nature.repository.CartRepository;
import com.example.Luana_Nature.repository.ProductRepository;
import com.example.Luana_Nature.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public void addInCart(User user, Product product, int quantity) {
        Cart cart = new Cart();
        cart.setUser(user);
        cart.setProduct(product);
        cart.setQuantity(quantity);
        cartRepository.save(cart);
    }



}
