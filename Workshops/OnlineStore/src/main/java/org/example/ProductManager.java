package org.example;

import java.util.List;

public class ProductManager {
    // Method to add a product to cart using its name
    public static void addToCart(String sku) {
        // Check if the ID is within the valid range
        List<Product> products = FileManager.getProducts();

        // Check if the SKU exists in the list of products
        boolean found = false;
        for (Product product : products) {
            if (product.getSku().equals(sku)) {
                found = true;
                System.out.println("Product found: " + product);
                break;
            }
        }

        // If product with given SKU is not found
        if (!found) {
            System.out.println("Product with SKU " + sku + " not found.");
        }
    }
}
