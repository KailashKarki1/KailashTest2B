package com.example.test2bkailash;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class HelloController {
    private static final String STATIC_USERNAME = "Kailash_Karki";
    private static final String STATIC_PASSWORD = "Kailash123";
    private static final int MAX_LOGIN_ATTEMPTS = 5; // Maximum allowed login attempts
    private int loginAttempts = 0; // Counter for login attempts

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label statusLabel;

    @FXML
    protected void onLoginButtonClick() {
        String enteredUsername = usernameField.getText();
        String enteredPassword = passwordField.getText();

        if (enteredUsername.equals(STATIC_USERNAME) && enteredPassword.equals(STATIC_PASSWORD)) {
            loginAttempts = 0; // Reset login attempts on successful login
            statusLabel.setText("Login Successful!!!");
        } else {
            loginAttempts++;
            if (loginAttempts >= MAX_LOGIN_ATTEMPTS) {
                statusLabel.setText("Sorry, Your Account is Locked!!!");
                // Disable login button or take appropriate action to prevent further attempts
            } else {
                statusLabel.setText("Sorry, Invalid Username or Password. Attempts left: " + (MAX_LOGIN_ATTEMPTS - loginAttempts));
            }
        }
    }
}
