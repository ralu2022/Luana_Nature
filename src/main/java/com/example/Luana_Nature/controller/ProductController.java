package com.example.Luana_Nature.controller;

import com.example.Luana_Nature.model.Product;
import com.example.Luana_Nature.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor


public class ProductController {

    private final ProductService productService;

    @GetMapping("/store")
    public String listAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "store";
    }

    @GetMapping("/product")
    public String productForm(Model model) {
        model.addAttribute("product", new Product());
        return "productform";
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestParam String name,
                             @RequestParam int price,
                             @RequestParam int stock,
                             @RequestParam String description,
                             @RequestParam String category) {
        productService.addProduct(name, price, stock, description, category);
        return "redirect:/products/products";
    }

}
