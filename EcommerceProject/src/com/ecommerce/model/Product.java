package com.ecommerce.model;

public class Product {

    private static int counter = 1000;

    private int productId;
    private String name, brand, category, description;
    private double price, discount;
    private int stock;

    public Product(String name, String brand, String category,
                   String description, double price, double discount, int stock) {

        this.productId = counter++;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
    }

    public int getProductId() { return productId; }
    public String getName() { return name; }
    public int getStock() { return stock; }

    public double getFinalPrice() {
        return price - (price * discount / 100);
    }

    // 🔥 FULL DISPLAY (important)
    public String toString() {
        return "\nID: " + productId +
               "\nName: " + name +
               "\nBrand: " + brand +
               "\nCategory: " + category +
               "\nDescription: " + description +
               "\nPrice: ₹" + price +
               "\nDiscount: " + discount + "%" +
               "\nFinal Price: ₹" + getFinalPrice() +
               "\nStock: " + stock +
               "\n----------------------";
    }
}