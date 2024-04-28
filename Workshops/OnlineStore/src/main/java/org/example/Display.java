package org.example;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Display {
    public static class StoreHomeScreen {
        private final Scanner scanner;

        public StoreHomeScreen(Scanner scanner) {
            this.scanner = scanner;
        }

        public void displayMenu() {
            try {
                while (true) {
                    System.out.println("The Store Home Screen");
                    System.out.println("1. Display Products");
                    System.out.println("2. Display Cart");
                    System.out.println("3. Exit");
                    System.out.print("Choose an option: ");

                    int input = scanner.nextInt();
                    // consume newline
                    scanner.nextLine();

                    switch (input) {
                        case 1:
                            // Display products
                            displayProducts();
                            break;
                        case 2:
                            //Display cart
                            displayCart();
                            break;
                        case 3:
                            // exit method
                            System.out.println("Exiting...");
                            return;
                        default:
                            System.out.println("Invalid choice. Please enter your choice again.");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                displayMenu();
            }
        }

        private void displayProducts() {

            DisplayProducts displayProducts = new DisplayProducts(scanner);
            displayProducts.displayMenu();
        }
        private void displayCart() {
            //List to store selected products
            List<Product> selectedProducts = new ArrayList<>();

            //Products from the file
            List<Product> products = FileManager.getProducts();

            //Display products to the user
            System.out.println("Available Products:");
            for (int i = 0; i < products.size(); i++) {
                System.out.println((i + 1) + ". " + products.get(i).getProductName());
            }

            try {
                while (true) {
                    System.out.print("Select a product to add to your cart (OR enter 0 to finish): ");
                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    // Exit the loop if user enters 0
                    if (choice == 0) {
                        break;
                    }

                    if (choice >= 1 && choice <= products.size()) {
                        // Add the selected product to the list of selected products
                        Product selectedProduct = products.get(choice - 1);
                        selectedProducts.add(selectedProduct);
                        System.out.println("Product added to cart: " + selectedProduct.getProductName());
                    } else {
                        System.out.println("Invalid choice. Please enter a valid product number.");
                    }
                }

                // Pass the selected products to the DisplayCart class
                DisplayCart displayCart = new DisplayCart(scanner, selectedProducts);
                displayCart.displayMenu();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    public static class DisplayProducts {
        private final Scanner scanner;

        public DisplayProducts(Scanner scanner) {
            this.scanner = scanner;
        }

        public void displayMenu() {
            try {
                while (true) {
                    System.out.println("Products Menu");
                    System.out.println("1. Search or filter the list of products");
                    System.out.println("2. Add a product to your cart");
                    System.out.println("3. Go Back to home page");
                    System.out.print("Choose an option: ");

                    int input = scanner.nextInt();
                    scanner.nextLine();

                    switch (input) {
                        case 1:
                            searchProducts();
                            break;
                        case 2:
                            addProductToCart();
                            break;
                        // return to previous menu
                        case 3:
                            return;
                        default:
                            System.out.println("Invalid choice. Please enter your choice again.");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                // restart the menu
                displayMenu();
            }
        }

        private void searchProducts() {
            //Method to search/filter products
            System.out.println("Searching or filtering products...");
        }

        private void addProductToCart() {
            //llist to store selected products
            List<Product> selectedProducts = new ArrayList<>();

            //Retrieve products from the file
            List<Product> products = FileManager.getProducts();

            //Display products to the user
            System.out.println("Available Products:");
            for (int i = 0; i < products.size(); i++) {
                System.out.println((i + 1) + ". " + products.get(i).getProductName());
            }

            try {
                while (true) {
                    System.out.print("Select a product to add to your cart (enter 0 to finish): ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (choice == 0) {
                        break; // Exit the loop if the user enters 0
                    }

                    if (choice >= 1 && choice <= products.size()) {
                        // Add the selected product to the list of selected products
                        Product selectedProduct = products.get(choice - 1);
                        selectedProducts.add(selectedProduct);
                        System.out.println("Product added to cart: " + selectedProduct.getProductName());
                    } else {
                        System.out.println("Invalid choice. Please enter a valid product number.");
                    }
                }

                // Pass the selected products to the DisplayCart class
                DisplayCart displayCart = new DisplayCart(scanner, selectedProducts);
                displayCart.displayMenu();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }


    public static class DisplayCart {
        private final Scanner scanner;
        private final List<Product> cart;

        public DisplayCart(Scanner scanner, List<Product> cart) {
            this.scanner = scanner;
            this.cart = cart;
        }

        public void displayMenu() {
            try {
                while (true) {
                    System.out.println("Your Cart:");
                    for (int i = 0; i < cart.size(); i++) {
                        System.out.println((i + 1) + ". " + cart.get(i).getProductName());
                    }
                    System.out.println("Cart Menu");
                    System.out.println("1. Check Out");
                    System.out.println("2. Remove product from cart");
                    System.out.println("3. Go Back to home screen");
                    System.out.print("Choose an option: ");

                    int input = scanner.nextInt();
                    scanner.nextLine();

                    switch (input) {
                        case 1:
                            checkOut();
                            break;
                        case 2:
                            removeProduct();
                            break;
                        // return to the previous menu
                        case 3:
                            return;
                        default:
                            System.out.println("Invalid choice. Please enter your choice again.");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                // restart the menu
                displayMenu();
            }
        }

        private void checkOut() {
            //Methos
            System.out.println("Checking out...");
            // Cheout
        }

        private void removeProduct() {
            try {
                System.out.print("Enter the index of the product to remove: ");
                int index = scanner.nextInt();
                scanner.nextLine();

                if (index >= 1 && index <= cart.size()) {
                    Product removedProduct = cart.remove(index - 1);
                    System.out.println("Removed from cart: " + removedProduct.getProductName());
                } else {
                    System.out.println("Invalid index. Please enter a valid product number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }
}
