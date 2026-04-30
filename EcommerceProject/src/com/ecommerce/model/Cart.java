package com.ecommerce.model;

import java.util.*;

public class Cart {

    private List<CartItem> items = new ArrayList<>();

    public void addItem(Product p, int q) {
        items.add(new CartItem(p, q));
    }

    public double getTotal() {
        double sum = 0;
        for (CartItem c : items)
            sum += c.getTotal();
        return sum;
    }

    public List<CartItem> getItems() {
        return items;
    }

    // 🔥 NEW METHOD
    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("❌ Cart is empty!");
            return;
        }

        System.out.println("\n🛒 YOUR CART:");
        for (CartItem c : items) {
            System.out.println(c);
        }

        System.out.println("💰 Total: ₹" + getTotal());
    }
}