package org.example.ps27852_lab8.rest.controller;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.example.ps27852_lab8.entity.Order;
import org.example.ps27852_lab8.entity.Product;
import org.example.ps27852_lab8.service.OrderrService;
import org.example.ps27852_lab8.service.ProductService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
@RequiredArgsConstructor
public class RestOrder {

    private final OrderrService orderService;

    @PostMapping
    public Order createOrder(@RequestBody JsonNode orderData) {
        return orderService.create(orderData);
    }

}
