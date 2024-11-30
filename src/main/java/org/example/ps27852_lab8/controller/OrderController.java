package org.example.ps27852_lab8.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.ps27852_lab8.entity.Order;
import org.example.ps27852_lab8.entity.OrderDetail;
import org.example.ps27852_lab8.service.OrderDetailService;
import org.example.ps27852_lab8.service.OrderrService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderrService orderService;
    private final OrderDetailService orderDetailService;

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

    @GetMapping("/paymentResult")
    public String paymentResult(@RequestParam Map<String, String> allParams, Model model) {
        String transactionStatus = allParams.get("vnp_ResponseCode");
        String transactionId = allParams.get("vnp_TransactionNo");
        String orderId = allParams.get("vnp_OrderInfo");

        if ("00".equals(transactionStatus)) {
            orderService.updatePaymentStatus(Integer.parseInt(orderId));
            model.addAttribute("message", "Giao dịch thành công.");
            model.addAttribute("status", "success");
        } else if ("24".equals(transactionStatus)) {
            Order order = orderService.findById(Integer.parseInt(orderId));
            Set<OrderDetail> orderDetails = order.getOrderDetails();

            for (OrderDetail orderDetail : orderDetails) {
                orderDetailService.deleteOrderDetail(orderDetail.getId());
            }

            orderService.deleteOrder(Integer.parseInt(orderId));
            model.addAttribute("message", "Giao dịch đã bị hủy.");
            model.addAttribute("status", "failed");
        } else {
            Order order = orderService.findById(Integer.parseInt(orderId));
            Set<OrderDetail> orderDetails = order.getOrderDetails();

            for (OrderDetail orderDetail : orderDetails) {
                orderDetailService.deleteOrderDetail(orderDetail.getId());
            }

            orderService.deleteOrder(Integer.parseInt(orderId));

            model.addAttribute("message", "Giao dịch thất bại với mã: " + transactionStatus);
            model.addAttribute("status", "failed");
        }

        model.addAttribute("transactionId", transactionId);

        return "order/PaySuccess";  // Đảm bảo đường dẫn không có lỗi
    }

}
