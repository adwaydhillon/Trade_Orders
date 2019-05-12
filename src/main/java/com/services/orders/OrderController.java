package com.services.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderservice;

    @GetMapping("/orders")
    public List getAllOrders() {
        return orderservice.getOrderList();
    }

    @GetMapping("/orders/summary")
    public OrderSummary getOrderSummary() {
        return orderservice.getOrderSummary();
    }

    @GetMapping("/orders/summary/security")
    public OrderSummary getOrderSummaryBySecurity(@RequestParam String security) {
        return orderservice.getOrderSummaryBySecurity(security);
    }

    @GetMapping("/orders/summary/fund")
    public OrderSummary getOrderSummaryByFund(@RequestParam String fund) {
        return orderservice.getOrderSummaryByFund(fund);
    }

    @PostMapping("/orders")
    public void addOrders(@RequestBody List<Order> orderList) {
        orderservice.addOrders(orderList);
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable String orderId) {
        orderservice.deleteOrder(orderId);
    }
}
