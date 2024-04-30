package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
    public List<Transaction> loadAllTransactionsFromFile() {
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(TRANSACTIONS_FILE_PATH))) {
            String line;
            boolean firstLine = true; // Flag to skip the first line
            while ((line = reader.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue; // Skip the header line
                }
            }
        } catch (FileNotFoundException e) {
            // Handle file not found exception
        } catch (IOException ex) {
            // Handle IO exception
        }
        return transactions;
    }

    /*
     * Writes a list of transactions to the transactions file.
     * @param transactions The list of transactions to write to the file.
     */
    public void writeTransactionsToFile(List<Transaction> transactions) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TRANSACTIONS_FILE_PATH, true))) {
            for (Transaction transaction : transactions) {
                writer.newLine();
                String formattedDate = transaction.getDate().format(DateTimeFormatter.ISO_DATE);
                String formattedTime = transaction.getTime().format(timeFormatter); // Use the timeFormatter
                writer.write(formattedDate + "|" + formattedTime + "|" + transaction.getDescription() + "|" + transaction.getVendor() + "|" + transaction.getAmount());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Gathers transaction data from user input, creates a new transaction object,
     * adds it to the list of transactions, writes transactions to the file,
     * reloads transactions from the file, and displays the updated list of transactions.
     */
    public void processNewTransaction(List<Transaction> transactions) {
        // Gather transaction data from user input
        System.out.println("Enter transaction description:");
        String description = scanner.nextLine();

        System.out.println("Enter transaction vendor:");
        String vendor = scanner.nextLine();

        double amount = 0.0; // Initialize amount
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Enter transaction amount:");
                amount = Double.parseDouble(scanner.nextLine());
                validInput = true; // Input is valid, exit loop
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for the amount.");
            }
        }

        // Create LocalDate and LocalTime objects for the current date and time
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        // Create a Transaction object with the current date and time, description, vendor, and amount
        Transaction transaction = new Transaction(currentDate, currentTime, description, vendor, amount);

        // Add the new transaction to the list of transactions
        transactions.add(transaction);

        // Write transactions to the file
        writeTransactionsToFile(transactions);

        // Reload transactions from the file (now includes the newly added transaction)
        transactions.clear(); // Clear existing transactions before loading
        transactions.addAll(loadAllTransactionsFromFile());

    }
}
