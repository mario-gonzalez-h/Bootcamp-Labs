package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Call the main method of UserInterface class
        UserInterface.main(args);

        TransactionManager transactionManager = new TransactionManager();
        // Call loadAllTransactionsFromFile method
        List<Transaction> transactions = transactionManager.loadAllTransactionsFromFile();


        Transaction transaction = new Transaction("25", "59","fsdfsd","dfsfs", 2.5);
        TransactionManager.writeTransactionsToFile(transaction);



    }
}