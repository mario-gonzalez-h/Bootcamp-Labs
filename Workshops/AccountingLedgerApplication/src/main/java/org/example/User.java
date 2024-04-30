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

    static String USER_ID_HISTORY_FILE_PATH = "src/main/resources/userIdHistory";

    /*
     * Static initialization block to read the last assigned ID from the file.
     * Handles IOException and NumberFormatException.
     */

    static {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_ID_HISTORY_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lastId = Integer.parseInt(line.trim()); // Trim any leading or trailing whitespace
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error reading userIdHistory file: " + e.getMessage());
        }
    }

    /*
     * Constructor to create a new User object with provided information.
     * @param name The name of the user.
     * @param email The email of the user.
     * @param address The address of the user.
     * @param phoneNumber The phone number of the user.
     */

    public User(String name, String email, String address, String phoneNumber) {
        this.id = ++lastId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters (omitted for brevity)


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

    /*
     * Save the last assigned ID to a file when the application exits.
     * Handles IOException.
     */
    public static void saveLastId() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_ID_HISTORY_FILE_PATH, true))) {
            writer.write(String.valueOf(lastId)); // Write the current ID into a new line
            writer.newLine(); // Write a new line after the ID
            lastId++; // Increment lastId after writing
        } catch (IOException e) {
            System.err.println("Error writing to userIdHistory file: " + e.getMessage());
        }
    }
}
