package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please Enter Your Name: ");
        String userName = scanner.nextLine();

        System.out.println("Hello " + userName + "! Please answer the following questions so that we can assist you with the value of the annuity!\n");

        System.out.print("Enter the monthly payout amount : ");
        double monthlyPayOut = scanner.nextDouble();

        System.out.print("Enter the annual interest rate: ");
        double annualInterestRate = scanner.nextDouble();
        double interestRate = annualInterestRate / 12 / 100;

        System.out.print("Enter the number of years to pay out: ");
        int yearsToPayOut = scanner.nextInt();
        int monthlyPayments = yearsToPayOut * 12;

        scanner.close();

        double presentValue = monthlyPayOut * ((1 - Math.pow(1 + interestRate, -monthlyPayments)) / interestRate);

        System.out.printf("Present Value of the annuity: $%.2f\n", presentValue);
    }
}