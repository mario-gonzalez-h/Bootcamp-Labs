package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransactionManager {
    private static final String TRANSACTIONS_FILE_PATH = "src/main/resources/transactions.csv";
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final Scanner scanner = new Scanner(System.in);

    /*
     * Reads all transactions from the transactions file and returns them as a list.
     * Each line in the file is assumed to represent a single transaction.
     * @return A list of transactions read from the file.
     */
    public static List<Transaction> loadAllTransactionsFromFile() {
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(TRANSACTIONS_FILE_PATH))) {
            // Skip the header line
            String header = reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 5) { // Ensure the line has correct format
                    LocalDate date = LocalDate.parse(parts[0]);
                    LocalTime time = LocalTime.parse(parts[1]);
                    String description = parts[2];
                    String vendor = parts[3];
                    double amount = Double.parseDouble(parts[4]);
                    Transaction transaction = new Transaction(date, time, description, vendor, amount);
                    transactions.add(transaction);
                } else {
                    System.out.println("Invalid transaction data: " + line);
                }
            }
        } catch (IOException | DateTimeParseException | NumberFormatException e) {
            e.printStackTrace();
        }
        return transactions;
    }



    /*
     * Writes a list of transactions to the transactions file.
     * @param transactions The list of transactions to write to the file.
     */
    public static void writeTransactionsToFile(List<Transaction> transactions) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TRANSACTIONS_FILE_PATH))) {
            for (Transaction transaction : transactions) {
                String formattedDate = transaction.getDate().format(DateTimeFormatter.ISO_DATE);
                String formattedTime = transaction.getTime().format(timeFormatter);
                writer.write(formattedDate + "|" + formattedTime + "|" + transaction.getDescription() + "|" + transaction.getVendor() + "|" + transaction.getAmount());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Process a deposit transaction.
     */
    public static void processDeposit(List<Transaction> transactions) {
        System.out.println("Enter payment amount:");
        double depositAmount = getValidAmountInput();

        System.out.println("Enter payment description:");
        String depositDescription = scanner.nextLine();

        System.out.println("Enter payment vendor:");
        String depositVendor = scanner.nextLine();

        // LocalDate and LocalTime objects for the current date and time
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        //Transaction object with the current date and time, description, vendor, and amount
        Transaction depositTransaction = new Transaction(currentDate, currentTime, depositDescription, depositVendor, depositAmount);

        // Add the deposit transaction to the list of transactions
        transactions.add(depositTransaction);

        // Write transactions to the file
        writeTransactionsToFile(transactions);
    }

    public static void processPayment(List<Transaction> transactions) {
        System.out.println("Enter payment amount:");
        double paymentAmount = getValidAmountInput();

        System.out.println("Enter payment description:");
        String paymentDescription = scanner.nextLine();

        System.out.println("Enter payment vendor:");
        String paymentVendor = scanner.nextLine();

        // Create LocalDate and LocalTime objects for the current date and time
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        // Create a Transaction object with the current date and time, description, vendor, and amount
        Transaction paymentTransaction = new Transaction(currentDate, currentTime, paymentDescription, paymentVendor, -paymentAmount);

        // Add the payment transaction to the list of transactions
        transactions.add(paymentTransaction);

        // Write transactions to the file
        writeTransactionsToFile(transactions);
    }
    /*
     * Helper method to get valid amount input from the user.
     */
    private static double getValidAmountInput() {
        double amount = 0.0;
        boolean validInput = false;
        while (!validInput) {
            try {
                amount = Double.parseDouble(scanner.nextLine());
                validInput = true; // Input is valid, exit loop
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for the amount:");
            }
        }
        return amount;
    }

    /*
     * Generate a report for transactions within the current month.
     */
    public static void generateMonthToDateReport(List<Transaction> transactions) {
        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();
        int currentYear = currentDate.getYear();

        System.out.println("Month To Date Report:");
        for (Transaction transaction : transactions) {
            LocalDate transactionDate = transaction.getDate();
            int transactionMonth = transactionDate.getMonthValue();
            int transactionYear = transactionDate.getYear();

            if (transactionMonth == currentMonth && transactionYear == currentYear) {
                System.out.println(transaction);
            }
        }
    }

    /*
     * Generate a report for transactions within the previous month.
     */
    public static void generatePreviousMonthReport(List<Transaction> transactions) {
        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();
        int currentYear = currentDate.getYear();

        int previousMonth = currentMonth - 1;
        int previousYear = currentYear;

        if (previousMonth == 0) {
            previousMonth = 12;
            previousYear--;
        }

        System.out.println("Previous Month Report:");
        for (Transaction transaction : transactions) {
            LocalDate transactionDate = transaction.getDate();
            int transactionMonth = transactionDate.getMonthValue();
            int transactionYear = transactionDate.getYear();

            if (transactionMonth == previousMonth && transactionYear == previousYear) {
                System.out.println(transaction);
            }
        }
    }

    /*
     * Generate a report for transactions within the current year.
     */
    public static void generateYearToDateReport(List<Transaction> transactions) {
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();

        System.out.println("Year To Date Report:");
        for (Transaction transaction : transactions) {
            LocalDate transactionDate = transaction.getDate();
            int transactionYear = transactionDate.getYear();

            if (transactionYear == currentYear) {
                System.out.println(transaction);
            }
        }
    }

    /*
     * Generate a report for transactions within the previous year.
     */
    public static void generatePreviousYearReport(List<Transaction> transactions) {
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();

        int previousYear = currentYear - 1;

        System.out.println("Previous Year Report:");
        for (Transaction transaction : transactions) {
            LocalDate transactionDate = transaction.getDate();
            int transactionYear = transactionDate.getYear();

            if (transactionYear == previousYear) {
                System.out.println(transaction);
            }
        }
    }
}