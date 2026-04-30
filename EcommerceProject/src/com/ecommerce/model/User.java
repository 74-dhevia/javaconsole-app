package com.ecommerce.model;

import java.util.Random;

public class User {
    private int userId;
    private String name, email, password;

    public User(String name, String email, String password) {
        this.userId = new Random().nextInt(10000);
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getUserId() { return userId; }
    public String getName() { return name; }
    public String getPassword() { return password; }

    public String toFile() {
        return userId + "," + name + "," + email + "," + password;
    }
}