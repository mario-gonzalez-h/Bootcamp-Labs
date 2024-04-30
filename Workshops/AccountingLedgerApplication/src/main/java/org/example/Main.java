package org.example;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import static org.example.UserInterface.runMenu;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserInterface.runMenu(scanner);
        scanner.close(); // Remember to close the scanner when done

    }

//        // Create TransactionManager instance
//        TransactionManager transactionManager = new TransactionManager();
//
//        // Load transactions from the file
//        List<Transaction> transactions = transactionManager.loadAllTransactionsFromFile();
//
//        // Process new transaction
//        transactionManager.processNewTransaction(transactions);
}


