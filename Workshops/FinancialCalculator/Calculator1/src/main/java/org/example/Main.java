package org.example;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please Enter Your Name: ");
        String userName = scanner.nextLine();

        System.out.println("Hello " + userName + "! Please answer the following questions so that we can assist you with your loan today!\n");

        System.out.print("Loan Amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Interest Rate: ");
        double interestRate = scanner.nextDouble();

        System.out.print("Loan Term In Years: ");
        int loanLenght = scanner.nextInt();

        double monthlyInterestRate = (interestRate/12)/100;
        DecimalFormat decimalFormat = new DecimalFormat("#.#####");

        int monthlyPayments = loanLenght * 12;
        DecimalFormat decimalFormat2 = new DecimalFormat("#.##");

        double M = mPayment(principal, monthlyInterestRate, monthlyPayments);
        System.out.println("Monthly Payment: $" + decimalFormat2.format(M));

        double totalInterest = (M * monthlyPayments) - principal;
        System.out.println("Total Interest Paid: $" + decimalFormat2.format(totalInterest));

        double totalCost = totalInterest + principal;
        System.out.println("Total Cost of Loan: $" + decimalFormat2.format(totalCost));


    }
    public static double mPayment(double p, double r, int n) {
        double numerator = p * r * Math.pow((1 + r), n);
        double denominator = Math.pow((1 + r), n) - 1;
        return numerator / denominator;
    }
}