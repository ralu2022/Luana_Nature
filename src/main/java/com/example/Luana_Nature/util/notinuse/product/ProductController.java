/*package com.example.Luana_Nature.util.notinuse.product;



import com.example.Luana_Nature.model.Product;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping("/store")
    public String listAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
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



}*/
