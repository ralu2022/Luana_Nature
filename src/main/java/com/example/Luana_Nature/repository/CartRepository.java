package com.example.Luana_Nature.repository;

import com.example.Luana_Nature.model.Cart;
import com.example.Luana_Nature.model.Product;
import com.example.Luana_Nature.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;


@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByUser(User user);
}
