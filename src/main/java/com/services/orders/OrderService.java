package com.services.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    private List<Order> orderList;

    @Scheduled(fixedDelay = 30000)
    public void getAllOrders() {
        List orderList = new ArrayList<>();
        orderRepository.findAll().forEach(orderList::add);
        this.orderList = orderList;
    }

    public OrderSummary getOrderSummary() {
        List<Order> orderList = this.orderList;

        long totalQuantity = 0;
        double totalPrice = 0;
        long combinableOrders = 0;
        HashMap<String, Long> combinableOrdersMap = new HashMap<>();

        for (Order order : orderList) {
            totalQuantity += order.getQuantity();
            totalPrice += order.getPrice();

            String key = order.getFund() + order.getSecurity() + order.getSide();
            if (combinableOrdersMap.containsKey(key)) {
                combinableOrdersMap.put(key, combinableOrdersMap.get(key) + 1);
            } else {
                combinableOrdersMap.put(key, Long.valueOf(1));
            }
        }

        for (String key : combinableOrdersMap.keySet()) {
            if (combinableOrdersMap.get(key) > 1) {
                combinableOrders++;
            }
        }

        OrderSummary orderSummary = new OrderSummary();
        orderSummary.setNumberOfOrders(orderList.size());
        orderSummary.setAveragePrice(totalPrice / (double) orderList.size());
        orderSummary.setTotalQuantity(totalQuantity);
        orderSummary.setNumberOfcombinableOrders(combinableOrders);

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
        long combinableOrders = 0;
        HashMap<String, Long> combinableOrdersMap = new HashMap<>();

        for (Order order : orderList) {
            totalQuantity += order.getQuantity();
            totalPrice += order.getPrice();

            String key = order.getFund() + order.getSide();
            if (combinableOrdersMap.containsKey(key)) {
                combinableOrdersMap.put(key, combinableOrdersMap.get(key) + 1);
            } else {
                combinableOrdersMap.put(key, Long.valueOf(1));
            }
        }

        for (String key : combinableOrdersMap.keySet()) {
            if (combinableOrdersMap.get(key) > 1) {
                combinableOrders++;
            }
        }

        OrderSummary orderSummary = new OrderSummary();
        orderSummary.setNumberOfOrders(orderList.size());
        orderSummary.setAveragePrice(totalPrice / (double) orderList.size());
        orderSummary.setTotalQuantity(totalQuantity);
        orderSummary.setNumberOfcombinableOrders(combinableOrders);

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
        long combinableOrders = 0;
        HashMap<String, Long> combinableOrdersMap = new HashMap<>();

        for (Order order : orderList) {
            totalQuantity += order.getQuantity();
            totalPrice += order.getPrice();

            String key = order.getSecurity() + order.getSide();
            if (combinableOrdersMap.containsKey(key)) {
                combinableOrdersMap.put(key, combinableOrdersMap.get(key) + 1);
            } else {
                combinableOrdersMap.put(key, Long.valueOf(1));
            }
        }

        OrderSummary orderSummary = new OrderSummary();
        orderSummary.setNumberOfOrders(orderList.size());
        orderSummary.setAveragePrice(totalPrice / (double)orderList.size());
        orderSummary.setTotalQuantity(totalQuantity);
        orderSummary.setNumberOfcombinableOrders(combinableOrders);

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
