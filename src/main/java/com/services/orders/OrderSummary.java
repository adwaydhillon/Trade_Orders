package com.services.orders;

public class OrderSummary {

    private long numberOfOrders = 0;
    private long totalQuantity = 0;
    private double averagePrice = 0;
    private long numberOfCombinableOrders = 0;

    public OrderSummary() {

    }

    public long getNumberOfOrders() {
        return numberOfOrders;
    }

    public void setNumberOfOrders(long numberOfOrders) {
        this.numberOfOrders = numberOfOrders;
    }

    public long getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(long totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public long getNumberOfCombinableOrders() {
        return numberOfCombinableOrders;
    }

    public void setNumberOfcombinableOrders(long numberOfCombinableOrders) {
        this.numberOfCombinableOrders = numberOfCombinableOrders;
    }
}
