package com.ecommerce.thread;

public class OrderThread extends Thread {
    public void run() {
        System.out.println("Order Processing in Background...");
    }
}