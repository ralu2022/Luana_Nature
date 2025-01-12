/*package com.example.Luana_Nature.util;


import com.example.Luana_Nature.model.Product;
import com.example.Luana_Nature.model.User;
import com.example.Luana_Nature.repository.ProductRepository;
import com.example.Luana_Nature.repository.UserRepository;
import com.example.Luana_Nature.service.CartService;
import com.example.Luana_Nature.service.MyUserPrincipal;
import com.example.Luana_Nature.util.notinuse.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/cart")
@RequiredArgsConstructor

public class CartController {

    private final CartRepository cartRepository;
    private final CartService cartService;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ProductService productService;

    @GetMapping("/cart")
    public String viewCart(@AuthenticationPrincipal MyUserPrincipal myUserPrincipal, Model model) {
        Optional<User> user = null;

        if (myUserPrincipal != null) {
            String userName = myUserPrincipal.getUsername();
            user = userRepository.findByUsername(userName);
            model.addAttribute("loggedUser", user);
        }


        if(user.isPresent()) {
            model.addAttribute("cartProducts",cartRepository.findByUserId(user.get().getId()));

            int totalPrice=0;
            for(Cart cart : cartRepository.findByUserId(user.get().getId())) {
                totalPrice+=cart.getProduct().getPrice();
            }
            model.addAttribute("totalPrice", totalPrice);
        }
        return "cart";
    }

    @GetMapping("/cartAdd")
    public String addCart(@RequestParam(name = "id") Long productId,@AuthenticationPrincipal MyUserPrincipal myUserPrincipal,
                          RedirectAttributes redirectAttributes) {
        if(myUserPrincipal != null) {
            if(productService.productExists(productId)){
                    Optional<User> user = userRepository.findByUsername(myUserPrincipal.getUsername());
                    Optional<Product> product = productRepository.findById(productId);
                    int quantity = 1;

                if(!cartService.itemExists(user.get().getId(),product.get().getId())) {
                    cartService.addToCart(user, product, quantity);
                } else {
                    redirectAttributes.addFlashAttribute("message", "Product is already in the cart!");
                }
            } else {
                redirectAttributes.addFlashAttribute("message", "Product does not exist!");
            }
        } else {
            redirectAttributes.addFlashAttribute("message", "You are not logged in");
        }
        return "redirect:/home";
    }
*/