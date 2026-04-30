package com.ecommerce.util;

import java.io.*;
import java.util.*;
import com.ecommerce.model.Product;

public class FileUtil {

    public static void save(String file, String data) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(data);
            bw.newLine();
            bw.close();
        } catch (Exception e) {
            System.out.println("File Error");
        }
    }

    public static List<Product> loadProducts() {
        List<Product> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("products.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");

                list.add(new Product(
                        d[1], d[2], d[3], d[4],
                        Double.parseDouble(d[5]),
                        Double.parseDouble(d[6]),
                        Integer.parseInt(d[7])
                ));
            }
            br.close();
        } catch (Exception e) {
            System.out.println("No product file");
        }
        return list;
    }

    public static void readOrders() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("orders.txt"));
            String line;

            System.out.println("---- ORDER HISTORY ----");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("No Orders");
        }
    }
}