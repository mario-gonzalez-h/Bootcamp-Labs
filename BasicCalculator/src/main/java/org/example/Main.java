package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Asking the user for their input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Possible Calculations:\n(A)dd\n(S)ubstract\n(M)ultiply\n(D)ivide\nPlease select an option: ");
        String selection = scanner.nextLine();
        // The two integers numbers which the user will utilize
        System.out.println("Please enter your first number: ");
        int firstNumber = scanner.nextInt();
        System.out.println("Please enter your second number: ");
        int secondNumber = scanner.nextInt();

        // Switch statement to select operation
        switch (selection.toLowerCase()) {
            case "a":
                addition(firstNumber, secondNumber);
                break;
            case "s":
                subtraction(firstNumber, secondNumber);
                break;
            case "m":
                multiplication(firstNumber, secondNumber);
                break;
            case "d":
                division(firstNumber, secondNumber);
                break;
            default:
                System.out.println("Invalid selection. Please choose A, S, M, or D.");
                break;
        }
    }

    // Function for addition
    public static void addition(int firstNumber, int secondNumber){
        int result = firstNumber + secondNumber;
        System.out.print("Your result is: " + result);
    }

    // Function for subtraction
    public static void subtraction(int firstNumber, int secondNumber){
        int result = firstNumber - secondNumber;
        System.out.print("Your result is: " + result);

    }

    // Function for multiplication
    public static void multiplication(int firstNumber, int secondNumber){
        int result = firstNumber * secondNumber;
        System.out.print("Your result is: " + result);
    }

    // Function for division
    public static void division(int firstNumber, int secondNumber){
        if (secondNumber != 0) {
            int result = firstNumber / secondNumber;
            System.out.print("Your result is: " + result);
        } else {
            System.out.println("Error: Cannot divide by zero.");
        }
    }
}