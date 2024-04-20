package org.example;
import java.util.Scanner;

import static org.example.Library.buyBook;

public class Main {
    //Instantiating the Library class
    private static Library library = new Library();
    //Setting the scanner to work accross the Main class
    private static Scanner scanner = new Scanner(System.in);

    //The display the user will utilize
    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to the Neighborhood Library!\n Select from the following options:\n");
            System.out.println("1) Show Available Books");
            System.out.println("2) Show Checked Out Books");
            System.out.println("3) Check Out a Book");
            System.out.println("4) Check In a Book");
            System.out.println("5) Buy a Book!");
            System.out.println("6) Exit\n");
            System.out.print("Please enter your choice: ");
            var input = scanner.nextInt();
            switch (input) {
                case 1:
                    library.showAvailableBooks();
                    break;
                case 2:
                    library.showCheckedOutBooks();
                    break;
                case 3:
                    checkOutBook();
                    break;
                case 4:
                    checkInBook();
                    break;
                case 5:
                    buyBook();
                case 6:
                    System.out.println("Thank you for using the Neighborhood Library!\nGood Bye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter your choice again.");
            }
        }
    }
    //Method for checking out a book
    private static void checkOutBook() {
        System.out.print("Enter the ID of the book you want to check out: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        //Calling the checkOutBook method from the Library class
        library.checkOutBook(id, name);
    }
    //Method for checking in a book
    private static void checkInBook() {
        System.out.print("Enter the ID of the book you want to check in: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        library.checkIn(id);
    }
}