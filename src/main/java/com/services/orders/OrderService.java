package com.services.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    private List<Order> orderList;

    @Scheduled(fixedDelay = 10000)
    public void getAllOrders() {
        List orderList = new ArrayList<>();
        orderRepository.findAll().forEach(orderList::add);
        this.orderList = orderList;
    }

    public OrderSummary getOrderSummary() {
        List<Order> orderList = this.orderList;

        long totalQuantity = 0;
        double totalPrice = 0;

        for (Order order : orderList) {
            totalQuantity += order.getQuantity();
            totalPrice += order.getPrice();
        }

        OrderSummary orderSummary = new OrderSummary();
        orderSummary.setNumberOfOrders(orderList.size());
        orderSummary.setAveragePrice(totalPrice / (double) orderList.size());
        orderSummary.setTotalQuantity(totalQuantity);

        return orderSummary;
    }

    public OrderSummary getOrderSummaryBySecurity(String security) {
        List<Order> orderList = new ArrayList<>();
        for (Order order : this.orderList) {
            if (order.getSecurity().equals(security)) {
                orderList.add(order);
            }
        }

        long totalQuantity = 0;
        double totalPrice = 0;

        for (Order order : orderList) {
            totalQuantity += order.getQuantity();
            totalPrice += order.getPrice();
        }

        OrderSummary orderSummary = new OrderSummary();
        orderSummary.setNumberOfOrders(orderList.size());
        orderSummary.setAveragePrice(totalPrice / (double) orderList.size());
        orderSummary.setTotalQuantity(totalQuantity);

        return orderSummary;
    }

    public OrderSummary getOrderSummaryByFund(String fund) {
        List<Order> orderList = new ArrayList<>();
        for (Order order : this.orderList) {
            if (order.getFund().equals(fund)) {
                orderList.add(order);
            }
        }

        long totalQuantity = 0;
        double totalPrice = 0;

        for (Order order : orderList) {
            totalQuantity += order.getQuantity();
            totalPrice += order.getPrice();
        }

        OrderSummary orderSummary = new OrderSummary();
        orderSummary.setNumberOfOrders(orderList.size());
        orderSummary.setAveragePrice(totalPrice / (double)orderList.size());
        orderSummary.setTotalQuantity(totalQuantity);

        return orderSummary;
    }

    public void addOrders(List<Order> orderList) {
        orderRepository.saveAll(orderList);
    }

    public void deleteOrder(String orderId) {
        orderRepository.deleteById(orderId);
    }

    public List<Order> getOrderList() {
        return this.orderList;
    }
}
