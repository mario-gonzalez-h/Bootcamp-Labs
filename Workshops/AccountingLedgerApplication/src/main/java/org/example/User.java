package org.example;

import java.io.*;
import java.util.Scanner;

public class User {
    // Static variable to keep track of the last assigned ID
    private static int lastId = 0;
    private int id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;


    static {
        String USER_ID_HISTORY_FILE_PATH = "src/main/resources/userIdHistory";
        // Read the last assigned ID from a file
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_ID_HISTORY_FILE_PATH))) {
            String line = reader.readLine();
            if (line != null && !line.isEmpty()) {
                lastId = Integer.parseInt(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading userIdHistory.csv: " + e.getMessage());
        }
    }

    public User(String name, String email, String address, String phoneNumber) {
        this.id = ++lastId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public User(String userInfoInput) {
        Scanner scanner = new Scanner(userInfoInput);

        System.out.print("Enter Name: ");
        setName(scanner.nextLine());

        System.out.print("Enter Email: ");
        setEmail(scanner.nextLine());

        System.out.print("Enter Address: ");
        setAddress(scanner.nextLine());

        System.out.print("Enter Phone Number: ");
        setPhoneNumber(scanner.nextLine());

        scanner.close();
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Save the last assigned ID to a file when the application exits
    public static void saveLastId() {
        String USER_ID_HISTORY_FILE_PATH = "src/main/resources/userIdHistory";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_ID_HISTORY_FILE_PATH,true))) {
            writer.write(String.valueOf(lastId));
        } catch (IOException e) {
            System.err.println("Error writing lastId.txt: " + e.getMessage());
        }
    }
}
