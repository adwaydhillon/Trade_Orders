package com.services.orders;

import javax.persistence.*;

@Entity
@Table(name = "order_table")
public class Order {
    @Id
    @Column(name="order_Id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long orderId;
    private String side = "";
    private String security = "";
    private String fund = "";
    private long quantity = 0;
    private double price = 0.0;

    public Order() {
    }

    public Order(Long id) {
        this.orderId = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setFund(String fund) {
        this.fund = fund;
    }

    public String getFund() {
        return fund;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public String getSecurity() {
        return security;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getSide() {
        return side;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
