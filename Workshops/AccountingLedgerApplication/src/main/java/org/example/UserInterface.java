package org.example;

import java.util.Scanner;

public class UserInterface {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Prompt the user to enter user information
        System.out.println("Enter user information (Name Email Address Phone):");
        String name = scanner.nextLine();
        String email = scanner.nextLine();
        String address = scanner.nextLine();
        String phoneNumber = scanner.nextLine();

        // Create a new User object using the provided information
        User user = new User(name, email, address, phoneNumber);

        // Display the user information
        System.out.println("User Information:");
        System.out.println("ID: " + user.getId());
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Address: " + user.getAddress());
        System.out.println("Phone Number: " + user.getPhoneNumber());

        // Save the last assigned ID to a file
        User.saveLastId();
    }



//        boolean isRunning = true;
//
//        while (isRunning) {
//            System.out.println("Welcome " + user + "!");
//            System.out.println("D) Add Deposit");
//            System.out.println("P) Make Payment (Debit)");
//            System.out.println("L) Ledger");
//            System.out.println("X) Exit");
//            System.out.print("Enter your choice: ");
//            String choice = scanner.nextLine().toUpperCase();
//
//            switch (choice) {
//                case "D":
//                    System.out.println("Add Deposit - Prompt user for deposit information and save it to the csv file");
//                    // Implement logic for adding deposit
//                    break;
//                case "P":
//                    System.out.println("Make Payment (Debit) - Prompt user for debit information and save it to the csv file");
//                    // Implement logic for making payment
//                    break;
//                case "L":
//                    System.out.println("Ledger - Display the ledger screen");
//                    // Implement logic for displaying ledger
//                    break;
//                case "X":
//                    System.out.println("Exiting the application...");
//                    isRunning = false;
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//                    break;
//            }
//        }
//        scanner.close();
//    }
}
