package com.ecommerce.model;

public class CartItem {

    private Product product;
    private int quantity;

    public CartItem(Product p, int q) {
        this.product = p;
        this.quantity = q;
    }

    public double getTotal() {
        return product.getFinalPrice() * quantity;
    }

    public String toString() {
        return product.getName() +
               " (ID: " + product.getProductId() + ")" +
               " x " + quantity +
               " = ₹" + getTotal();
    }
}