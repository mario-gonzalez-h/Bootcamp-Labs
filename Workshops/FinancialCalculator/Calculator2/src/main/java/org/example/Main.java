package org.example;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please Enter Your Name: ");
        String userName = scanner.nextLine();

        System.out.println("Hello " + userName + "! Please answer the following questions so that we can assist you with your future value and total interest earned today!\n");

        System.out.print("Enter Initial Deposit: ");
        double initialDeposit = scanner.nextDouble();

        System.out.print("Enter Annual Interest Rate: ");
        double annualInterestRate = scanner.nextDouble();
        double annualInterestRateDecimal = annualInterestRate/100;

        System.out.print("Enter Term In Years: ");
        double termInYears = scanner.nextDouble();
        double n = 365;
        double dailyInterestRate = annualInterestRateDecimal/n;

        double futureValue = futureValueCalc(initialDeposit, annualInterestRateDecimal, termInYears);

        double totalInterest = futureValue - initialDeposit;

        DecimalFormat decimalFormat2 = new DecimalFormat("#.##");
        // Display future value and total interest earned
        System.out.println("Future Value: " + decimalFormat2.format(futureValue));
        System.out.println("Total Interest Earned: " + decimalFormat2.format(totalInterest));
    }


    public static double futureValueCalc(double initialDeposit, double interestRate, double yearsTime) {
        int n = 365;
        double result = initialDeposit * Math.pow(1 + interestRate / n, n * yearsTime);
        return result;
    }
}