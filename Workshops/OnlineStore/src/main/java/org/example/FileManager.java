package org.example;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {
    public static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        String file = "src/main/resources/products.csv";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            bufferedReader.readLine();
            //While loop to read file
            while((line = bufferedReader.readLine()) != null){
                //splitting data on every pipe
                String[] productsData = line.split("\\|");
                if(productsData.length !=4){
                    System.out.println("Invalid data format: " + line);
                    continue;
                }
                try{
                    String sku = productsData[0];
                    String productsName = productsData[1];
                    double price = Double.parseDouble(productsData[2]);
                    String department = productsData[3];

                    Product product = new Product(sku, productsName, price, department);
                    products.add(product);
                } catch (Exception e) {
                    System.out.println("Invalid numeric data format: " + line);
                    throw new RuntimeException(e);
                }

            }
            for (Product product : products) {
                System.out.printf("SKU: %s, Product Name: %s, Price: $%.2f, Department: %s\n",
                        product.getSku(), product.getProductName(), product.getPrice(), product.getDepartment());
            }


        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return products;

    }

}