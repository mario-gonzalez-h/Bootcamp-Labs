package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

    private static final String TRANSACTIONS_FILE_PATH = "src/main/resources/transactions.csv";

     /*
     -Reads all transactions from the transactions file and returns them as a list.
     -Each line in the file is assumed to represent a single transaction.
     -@return A list of transactions read from the file.
     */

    public List<Transaction> loadAllTransactionsFromFile() {
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(TRANSACTIONS_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line); // Print each line read from the file

                Transaction transaction = new Transaction(line);
                transactions.add(transaction);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: Transactions file not found at path: " + TRANSACTIONS_FILE_PATH);
            e.printStackTrace();
        } catch (IOException ex) {
            System.err.println("Error reading the file: " + ex.getMessage());
            ex.printStackTrace();
        }
        return transactions;
    }

    /*
     * Writes a single transaction to the transactions file.
     * @param transaction The transaction to write to the file.
     */
    public static void writeTransactionsToFile(Transaction transaction) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TRANSACTIONS_FILE_PATH, true))) {
            writer.newLine();
            writer.write(transaction.getDate() + "|" + transaction.getTime() + "|" + transaction.getDescription() + "|" + transaction.getVendor() + "|" + transaction.getAmount()); // Assuming Transaction class overrides toString() method
        } catch (IOException e) {
            // Print or handle the exception as needed
            e.printStackTrace();
        }
    }
}
