package com.ecommerce.model;

public class Admin extends User {
    public Admin(String n, String e, String p) {
        super(n, e, p);
    }

    public boolean login(String u, String p) {
        return getName().equals(u) && getPassword().equals(p);
    }
}