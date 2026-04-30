package com.ecommerce.main;

import java.util.*;
import com.ecommerce.model.*;
import com.ecommerce.service.*;
import com.ecommerce.util.FileUtil;
import com.ecommerce.thread.OrderThread;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ECommerceService service = new ECommerceService();

        while (true) {

            System.out.println("\n====================================");
            System.out.println("        E-COMMERCE SYSTEM");
            System.out.println("====================================");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            // ================= ADMIN =================
            if (choice == 1) {

                Admin admin = new Admin("admin", "mail", "123");

                System.out.print("\nEnter Username: ");
                String u = sc.nextLine();
                System.out.print("Enter Password: ");
                String p = sc.nextLine();

                if (admin.login(u, p)) {

                    System.out.println("✅ Admin Login Successful!");

                    while (true) {
                        System.out.println("\n------ ADMIN MENU ------");
                        System.out.println("1. Add Product");
                        System.out.println("2. Remove Product");
                        System.out.println("3. View Products");
                        System.out.println("4. Logout");
                        System.out.print("Enter choice: ");

                        int ch = sc.nextInt();
                        sc.nextLine();

                        if (ch == 1) {

                            System.out.print("Name: ");
                            String name = sc.nextLine();

                            System.out.print("Brand: ");
                            String brand = sc.nextLine();

                            System.out.print("Category: ");
                            String category = sc.nextLine();

                            System.out.print("Description: ");
                            String desc = sc.nextLine();

                            System.out.print("Price: ");
                            double price = sc.nextDouble();

                            System.out.print("Discount: ");
                            double discount = sc.nextDouble();

                            System.out.print("Stock: ");
                            int stock = sc.nextInt();

                            service.addProduct(new Product(name, brand, category, desc, price, discount, stock));

                            System.out.println("✅ Product Added Successfully!");
                        }

                        else if (ch == 2) {
                            System.out.print("Enter Product ID to remove: ");
                            int id = sc.nextInt();
                            service.removeProduct(id);
                            System.out.println("🗑️ Product Removed Successfully!");
                        }

                        else if (ch == 3) {
                            service.viewProducts();
                        }

                        else {
                            System.out.println("🔒 Admin Logged Out!");
                            break;
                        }
                    }
                } else {
                    System.out.println("❌ Invalid Admin Login!");
                }
            }

            // ================= USER =================
            else if (choice == 2) {

                System.out.println("\n1. Register");
                System.out.println("2. Login");
                System.out.print("Enter choice: ");

                int ch = sc.nextInt();
                sc.nextLine();

                if (ch == 1) {
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Password: ");
                    String pass = sc.nextLine();

                    service.register(new User(name, email, pass));
                    System.out.println("✅ Registration Successful!");
                }

                System.out.println("\n--- USER LOGIN ---");
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Password: ");
                String pass = sc.nextLine();

                User user = service.login(name, pass);

                if (user != null) {

                    System.out.println("✅ Login Successful!");

                    Cart cart = new Cart();

                    while (true) {

                        System.out.println("\n--------- USER MENU ---------");
                        System.out.println("1. View Products");
                        System.out.println("2. Search Product");
                        System.out.println("3. Add to Cart");
                        System.out.println("4. View Cart");   // 🔥 updated
                        System.out.println("5. Place Order");
                        System.out.println("6. View Orders");
                        System.out.println("7. Logout");
                        System.out.print("Enter choice: ");

                        int uc = sc.nextInt();

                        if (uc == 1) {
                            service.viewProducts();
                        }

                        else if (uc == 2) {
                            sc.nextLine();
                            System.out.print("Enter product name: ");
                            service.searchProduct(sc.nextLine());
                        }

                        else if (uc == 3) {
                            System.out.print("Enter Product ID: ");
                            int id = sc.nextInt();

                            System.out.print("Enter Quantity: ");
                            int q = sc.nextInt();

                            Product p = service.getProduct(id);

                            if (p != null) {
                                cart.addItem(p, q);
                                System.out.println("🛒 Product Added to Cart!");
                            } else {
                                System.out.println("❌ Invalid Product ID!");
                            }
                        }

                        else if (uc == 4) {
                            cart.viewCart();   // 🔥 shows cart
                        }

                        else if (uc == 5) {

                            if (cart.getItems().isEmpty()) {
                                System.out.println("❌ Cart is empty!");
                                continue;
                            }

                            cart.viewCart();

                            sc.nextLine();
                            System.out.print("Confirm Order? (yes/no): ");
                            String confirm = sc.nextLine();

                            if (!confirm.equalsIgnoreCase("yes")) {
                                System.out.println("❌ Order Cancelled!");
                                continue;
                            }

                            Order order = new Order(cart.getItems(), cart.getTotal(), user.getName());
                            FileUtil.save("orders.txt", order.getDetails());

                            new OrderThread().start();

                            System.out.println("\nSelect Payment Method:");
                            System.out.println("1. UPI");
                            System.out.println("2. Card");

                            int pc = sc.nextInt();

                            Payment pay = (pc == 1) ? new UpiPayment() : new CardPayment();
                            pay.pay(cart.getTotal());

                            System.out.println("✅ Order Placed Successfully!");

                            cart.getItems().clear();
                        }

                        else if (uc == 6) {
                            FileUtil.readOrders();
                        }

                        else {
                            System.out.println("🔒 Logged out successfully!");
                            break;
                        }
                    }
                } else {
                    System.out.println("❌ Invalid Login!");
                }
            }

            else {
                System.out.println("🙏 Thank you!");
                break;
            }
        }

        sc.close();
    }
}