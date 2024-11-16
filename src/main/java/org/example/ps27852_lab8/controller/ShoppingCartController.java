package org.example.ps27852_lab8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {
    @GetMapping("/viewCart")
    public String viewCart() {
        return "cart/ShoppingCart";
    }
}
