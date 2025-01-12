package com.example.Luana_Nature.service;


import com.example.Luana_Nature.model.Product;
import com.example.Luana_Nature.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public void addProduct(String name, int price, int stock, String description, String category){
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setStock(stock);
        product.setDescription(description);
        product.setCategory(category);
        productRepository.save(product);
    }

}
