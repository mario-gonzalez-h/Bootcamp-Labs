package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Call the runMenu method from UserInterface class
        UserInterface.runMenu(scanner);

        scanner.close();
    }
}
