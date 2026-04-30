package com.ecommerce.service;

import com.ecommerce.model.*;
import java.util.*;

public class ECommerceService {

    private List<Product> products = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public void removeProduct(int id) {
        products.removeIf(p -> p.getProductId() == id);
    }

    public void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available");
            return;
        }
        for (Product p : products) System.out.println(p);
    }

    public Product getProduct(int id) {
        for (Product p : products)
            if (p.getProductId() == id) return p;
        return null;
    }

    public void searchProduct(String name) {
        for (Product p : products)
            if (p.getName().equalsIgnoreCase(name))
                System.out.println(p);
    }

    public void register(User u) {
        users.add(u);
    }

    public User login(String name, String pass) {
        for (User u : users)
            if (u.getName().equals(name) && u.getPassword().equals(pass))
                return u;
        return null;
    }
}