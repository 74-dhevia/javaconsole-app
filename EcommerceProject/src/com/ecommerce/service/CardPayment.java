package com.ecommerce.service;

public class CardPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid via Card: " + amount);
    }
}