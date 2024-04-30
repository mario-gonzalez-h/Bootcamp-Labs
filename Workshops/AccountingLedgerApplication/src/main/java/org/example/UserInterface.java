package org.example;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private static Scanner scanner = new Scanner(System.in);

    /*
     * Prompt the user to enter user information and create a User object.
     * @return The User object created with the provided information.
     */

    public static User collectUserInfo() {
        // Prompt the user to enter user information
        System.out.println("Enter user information:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        // Create a new User object using the provided information
        User user = new User(name, email, address, phoneNumber);

        // Save the last assigned ID to a file
        User.saveLastId();

        return user;
    }

    /*
     * Runs the main menu for the user interface.
     */

    public static void runMenu(Scanner scanner) {
        boolean isRunning = true;

        // Collect user information
        User user = collectUserInfo();

        while (isRunning) {
            // Welcome message
            System.out.println("Welcome " + user.getName() + "!");
            System.out.println("Your user ID is: " + user.getId());

            // Display menu
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "D":
                    System.out.println("Add Deposit - Prompt user for deposit information and save it to the csv file");
                    //logic for adding deposit
                    break;
                case "P":
                    System.out.println("Make Payment (Debit) - Prompt user for debit information and save it to the csv file");
                    //logic for making payment
                    break;
                case "L":
                    System.out.println("Ledger - Display the ledger screen");
                    displayLedgerOptions(scanner);
                    break;
                case "X":
                    System.out.println("Exiting the application...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    /*
     * Displays options for the ledger screen and handles user input.
     */

    private static void displayLedgerOptions(Scanner scanner) {
        boolean isLedgerRunning = true;
        TransactionManager transactionManager = new TransactionManager(); // Create an instance

        while (isLedgerRunning) {
            System.out.println("A) All - Display all entries");
            System.out.println("D) Deposits - Display only the entries that are deposits into the account");
            System.out.println("P) Payments - Display only the negative entries (or payments)");
            System.out.println("R) Reports - A new screen that allows the user to run pre-defined reports or to run a custom search");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "A":
                    System.out.println("Display all entries");
                    // Load transactions from the file
                    List<Transaction> transactions = transactionManager.loadAllTransactionsFromFile();
                    // Process transactions as needed
                    break;
                case "D":
                    System.out.println("Display only the entries that are deposits into the account");
                    // Logic for displaying deposits
                    break;
                case "P":
                    System.out.println("Display only the negative entries (or payments)");
                    // Logic for displaying payments
                    break;
                case "R":
                    displayReportOptions(scanner);
                    break;
                case "H":
                    System.out.println("Go back to Home Screen");
                    isLedgerRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    /*
     * Displays options for the reports screen and handles user input.
     */

    private static void displayReportOptions(Scanner scanner) {
        boolean isReportRunning = true;

        while (isReportRunning) {
            System.out.println("Reports");
            System.out.println("  1) Month To Date");
            System.out.println("  2) Previous Month");
            System.out.println("  3) Year To Date");
            System.out.println("  4) Previous Year");
            System.out.println("  5) Search by Vendor - prompt the user for the vendor name and display all entries for that vendor");
            System.out.println("  0) Back - go back to the ledger page");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Month To Date Report");
                    //logic for month to date report
                    break;
                case "2":
                    System.out.println("Previous Month Report");
                    //logic for previous month report
                    break;
                case "3":
                    System.out.println("Year To Date Report");
                    // logic for year to date report
                    break;
                case "4":
                    System.out.println("Previous Year Report");
                    //for previous year report
                    break;
                case "5":
                    System.out.println("Search by Vendor");
                    //for searching by vendor
                    break;
                case "0":
                    isReportRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}

