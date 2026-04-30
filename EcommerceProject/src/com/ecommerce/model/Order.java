package com.ecommerce.model;

import java.util.*;
import java.time.*;

public class Order {

    private static int count = 500;

    private int orderId;
    private List<CartItem> items;
    private double total;

    private String userName;
    private LocalDateTime orderDate;

    // 🔥 Constructor
    public Order(List<CartItem> items, double total, String userName) {
        this.orderId = count++;
        this.items = new ArrayList<>(items); // copy to avoid reference issue
        this.total = total;
        this.userName = userName;
        this.orderDate = LocalDateTime.now(); // auto date & time
    }

    public int getOrderId() {
        return orderId;
    }

    public double getTotal() {
        return total;
    }

    public String getUserName() {
        return userName;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public List<CartItem> getItems() {
        return items;
    }

    // 🔥 Detailed Order Info
    public String getDetails() {
        return "Order ID: " + orderId +
               " | User: " + userName +
               " | Total: ₹" + total +
               " | Date: " + orderDate +
               " | Items: " + items;
    }

    // 🔥 Important (for printing automatically)
    public String toString() {
        return getDetails();
    }
}