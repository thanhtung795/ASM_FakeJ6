package org.example.ps27852_lab8.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.aspectj.weaver.ast.Or;
import org.example.ps27852_lab8.entity.Order;

import java.util.List;

public interface OrderrService {
    Order create(JsonNode orderData );
    Order findById(Integer id);
    List<Order> getAllOrderByUsername(String username);
}
