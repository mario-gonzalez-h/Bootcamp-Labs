package org.example;

import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
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
        TransactionManager transactionManager = new TransactionManager(); // Create an instance

        boolean isRunning = true;

        // Collect user information
        User user = collectUserInfo();
        List<Transaction> transactions = TransactionManager.loadAllTransactionsFromFile();

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
                    System.out.println("Add Deposit");
                    transactionManager.processDeposit(transactions);
                    break;
                case "P":
                    System.out.println("Make Payment (Debit)");
                    transactionManager.processPayment(transactions);
                    break;
                case "L":
                    System.out.println("Ledger Screen");
                    displayLedgerOptions(transactions);
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
    public static void displayLedgerOptions(List<Transaction> transactions) {
        boolean isLedgerRunning = true;

        while (isLedgerRunning) {
            System.out.println("A) All - Display all entries");
            System.out.println("D) Deposits - Display only the entries that are deposits into the account");
            System.out.println("P) Payments - Display only the negative entries (or payments)");
            System.out.println("R) Reports - A new screen that allows the user to run pre-defined reports or to run a custom search");
            System.out.println("H) Home - return to the home screen");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().toUpperCase();

            switch (choice) {
                case "A":
                    System.out.println("All Entries");
                    for (Transaction transaction : transactions) {
                        System.out.println(transaction);
                    }
                    break;
                case "D":
                    System.out.println("Deposit Entries");
                    for (Transaction transaction : transactions) {
                        if (transaction.getAmount() > 0) {
                            System.out.println(transaction);
                        }
                    }
                    break;
                case "P":
                    System.out.println("Payment Entries (negative entries or payments)");
                    for (Transaction transaction : transactions) {
                        if (transaction.getAmount() < 0) {
                            System.out.println(transaction);
                        }
                    }
                    break;
                case "R":
                    displayReportOptions(scanner, transactions);
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

    private static void displayReportOptions(Scanner scanner, List<Transaction> transactions) {
        boolean isReportRunning = true;

        while (isReportRunning) {
            System.out.println("Reports");
            System.out.println("  1) Month To Date Entries");
            System.out.println("  2) Previous Month Entries");
            System.out.println("  3) Year To Date Entries");
            System.out.println("  4) Previous Year Entries");
            System.out.println("  5) Search by Criteria Entries");
            System.out.println("  0) Back");

            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Month To Date Report");
                    TransactionManager.generateMonthToDateReport(transactions);
                    break;
                case "2":
                    System.out.println("Previous Month Report");
                    TransactionManager.generatePreviousMonthReport(transactions);
                    break;
                case "3":
                    System.out.println("Year To Date Report");
                    TransactionManager.generateYearToDateReport(transactions);
                    break;
                case "4":
                    System.out.println("Previous Year Report");
                    TransactionManager.generatePreviousYearReport(transactions);
                    break;
                case "5":
                    System.out.println("Search by Transaction");
                    searchTransactions(scanner, transactions);
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

    /*
     * Prompt the user for custom transactions.
     */
    private static void searchTransactions(Scanner scanner, List<Transaction> transactions) {
        System.out.println("Enter search criteria:");
        System.out.println("1. Start Date");
        System.out.println("2. End Date");
        System.out.println("3. Description");
        System.out.println("4. Vendor");
        System.out.println("5. Amount");
        System.out.print("Choose an option: ");

        int option = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (option) {
            case 1:
                System.out.print("Enter start date (yyyy-MM-dd): ");
                LocalDate startDate = LocalDate.parse(scanner.nextLine());
                searchByStartDate(transactions, startDate);
                break;
            case 2:
                System.out.print("Enter end date (yyyy-MM-dd): ");
                LocalDate endDate = LocalDate.parse(scanner.nextLine());
                searchByEndDate(transactions, endDate);
                break;
            case 3:
                System.out.print("Enter description: ");
                String description = scanner.nextLine();
                searchByDescription(transactions, description);
                break;
            case 4:
                System.out.print("Enter vendor name: ");
                String vendorName = scanner.nextLine();
                searchByVendor(transactions, vendorName);
                break;
            case 5:
                System.out.print("Enter amount: ");
                double amount = scanner.nextDouble();
                searchByAmount(transactions, amount);
                break;
            default:
                System.out.println("Invalid option selected.");
        }
    }
    /* Methods used for the custom search for SearchTransaction*/
    private static void searchByStartDate(List<Transaction> transactions, LocalDate startDate) {
        boolean found = false;
        for (Transaction transaction : transactions) {
            if (transaction.getDate().isAfter(startDate) || transaction.getDate().isEqual(startDate)) {
                System.out.println(transaction);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No transactions found after or on the start date: " + startDate);
        }
    }

    private static void searchByEndDate(List<Transaction> transactions, LocalDate endDate) {
        boolean found = false;
        for (Transaction transaction : transactions) {
            if ((transaction.getDate().isBefore(endDate) || transaction.getDate().isEqual(endDate))
                    && transaction.getAmount() > 0.0) {
                System.out.println(transaction);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No transactions found before or on the end date or remaining amount is above 0.0: " + endDate);
        }
    }

    private static void searchByDescription(List<Transaction> transactions, String description) {
        boolean found = false;
        for (Transaction transaction : transactions) {
            if (transaction.getDescription().equalsIgnoreCase(description)) {
                System.out.println(transaction);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No transactions found with description: " + description);
        }
    }

    private static void searchByVendor(List<Transaction> transactions, String vendorName) {
        boolean found = false;
        for (Transaction transaction : transactions) {
            if (transaction.getVendor().equalsIgnoreCase(vendorName)) {
                System.out.println(transaction);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No transactions found for vendor: " + vendorName);
        }
    }

    private static void searchByAmount(List<Transaction> transactions, double amount) {
        boolean found = false;
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() == amount) {
                System.out.println(transaction);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No transactions found with amount: " + amount);
        }
    }
}
