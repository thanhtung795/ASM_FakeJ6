package org.example.ps27852_lab8.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.ps27852_lab8.entity.Order;
import org.example.ps27852_lab8.entity.OrderDetail;
import org.example.ps27852_lab8.enums.OrderStatus;
import org.example.ps27852_lab8.repository.OrderDetailRepository;
import org.example.ps27852_lab8.repository.OrderRepository;
import org.example.ps27852_lab8.service.OrderrService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderrService {

    private final OrderRepository orderRepository;

    private final OrderDetailRepository orderDetailRepository;

    @Override
    public Order create(JsonNode orderData) {
        ObjectMapper mapper = new ObjectMapper();

        Order order = mapper.convertValue(orderData,Order.class);
        orderRepository.save(order);

        TypeReference<List<OrderDetail>> type = new TypeReference<>(){};
        List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"),type)
                .stream().peek(d-> d.setOrder(order)).collect(Collectors.toList());
        orderDetailRepository.saveAll(details);
        details.forEach(x -> System.out.println(x.toString()));
        return order;
    }

    @Override
    public Order findById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> getAllOrderByUsername(String username) {
        return orderRepository.getAllOrderByUsername(username);
    }

    @Override
    public Order updatePaymentStatus(Integer id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy đơn hàng"));
        order.setStatus(OrderStatus.PAID);
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}
