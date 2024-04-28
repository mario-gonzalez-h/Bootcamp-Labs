package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Display.StoreHomeScreen storeHomeScreen = new Display.StoreHomeScreen(scanner);
        storeHomeScreen.displayMenu();
        scanner.close();
    }
}