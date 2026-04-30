package com.ecommerce.service;

public class UpiPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid via UPI: " + amount);
    }
}