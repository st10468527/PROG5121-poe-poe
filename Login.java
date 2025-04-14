/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poe;
import javax.swing.*;
/**
 *
 * @author RC_Student_lab
 */
public class Login {
     // Class to handle user registration and validation logic
    public class Registration {
        private String username;
        private String password;
        private String cellNumber;
        private String firstName;
        private String lastName;

        // This method is to display password validation or registration result to the user
        public void checkPasswordComplexity(String message) {
            JOptionPane.showMessageDialog(null, message);
        }

        // This method is used to validate the username
        // Username must contain an underscore and be 5 characters or less
        public boolean isValidUsername(String username) {
            return username.contains("_") && username.length() <= 5;
        }

        // This method is to validate the password
        // Password must be at least 8 characters long, contain uppercase, digit, and special character
        public boolean isValidPassword(String password) {
            return password.length() >= 8 &&
                   password.matches(".*[A-Z].*") &&
                   password.matches(".*[0-9].*") &&
                   password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
        }

        // This method is to validate South African phone number format
        public boolean isValidCellNumber(String cellNumber) {
            return cellNumber.matches("^\\+27[0-9]{9}$");
        }

        // This method is to register user -with this,it validates all fields and stores data if valid
        public String registerUser(String username, String password, String cellNumber, String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
            JOptionPane.showMessageDialog(null, "welcome to champChat:\n"+"lets get you logged in!!");

            StringBuilder result = new StringBuilder();

            // this validates and stores the username
            if (!isValidUsername(username)) {
                result.append("Username is not correctly formatted. It must contain an underscore and be no more than five characters in length.\n");
            } else {
                this.username = username;
                result.append("Username successfully captured.\n");
            }

            // This validates and storesthe password
            if (!isValidPassword(password)) {
                result.append("Password must be at least 8 characters long and include an uppercase letter, a digit, and a special character.\n");
            } else {
                this.password = password;
                result.append("Password successfully captured.\n");
            }

            // This validates and stores the cellphone number
            if (!isValidCellNumber(cellNumber)) {
                result.append("Cell number must start with +27 and contain 9 digits.\n");
            } else {
                this.cellNumber = cellNumber;
                result.append("Cell number successfully captured.\n");
            }

            return result.toString(); // This returns the registration feedback
        }

        // This Method is to check if the provided login credentials match the stored values
        public boolean loginUser(String username, String password) {
            return this.username != null && this.password != null &&
                   this.username.equals(username) && this.password.equals(password);
        }
    }
    
}
