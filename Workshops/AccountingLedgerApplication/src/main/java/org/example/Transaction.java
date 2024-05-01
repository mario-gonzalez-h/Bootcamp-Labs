package org.example;

import java.time.LocalDate;
import java.time.LocalTime;

public class Transaction {
    private final LocalDate date;
    private final LocalTime time;
    private String description;
    private String vendor;
    private double amount;

    /*
     * Constructor to create a Transaction object with provided information.
     * @param date The date of the transaction.
     * @param time The time of the transaction.
     * @param description The description of the transaction.
     * @param vendor The vendor related to the transaction.
     * @param amount The amount of the transaction.
     */

    public Transaction(LocalDate date, LocalTime time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    /*
     * Constructor to parse a string and initialize fields.
     * Assumes the string follows the format: "date|time|description|vendor|amount".
     * @param line The string representing the transaction.
     */

    public Transaction(String line) {
        String[] lines = line.split("\\|");
        this.date = LocalDate.parse(lines[0]);
        this.time = LocalTime.parse(lines[1]);
        this.description = lines[2];
        this.vendor = lines[3];
        this.amount = Double.parseDouble(lines[4]);
    }

    //Getters and Setters

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    @Override
    public String toString() {
        return "Date: " + date + ", Time: " + time + ", Description: " + description + ", Vendor: " + vendor + ", Amount: " + amount;
    }
}
