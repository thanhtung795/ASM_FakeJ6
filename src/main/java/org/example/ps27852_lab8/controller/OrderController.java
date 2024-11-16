package org.example.ps27852_lab8.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.ps27852_lab8.service.OrderrService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderrService orderService;


    @GetMapping("/checkout")
    public String checkout() {
        return "order/checkout";
    }

    @GetMapping("/viewOrders")
    public String viewOrders(HttpServletRequest request) {
        String username = request.getRemoteUser();
        request.setAttribute("orders", orderService.getAllOrderByUsername(username));
        return "order/viewOrders";
    }

    @GetMapping("/detail/{id}")
    public String detailProduct(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("order", orderService.findById(id));
        return "order/detail";
    }
}
