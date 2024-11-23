package com.example.demo.entity;

import com.example.demo.service.ServiceHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.persistence.*;

@Component
@Entity
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long currentUserId;

    @Autowired
    private ServiceHandler serviceHandler;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(Long currentUserId) {
        this.currentUserId = currentUserId;
    }

    // Functions
    /**
     * Registers a new user by delegating the operation to the ServiceHandler.
     *
     * @param username The username of the new user.
     * @param email The email of the new user.
     * @param password The password of the new user.
     * @return true if registration is successful, false otherwise.
     */
    public boolean registerUser(String username, String email, String password) {
        try {
            User newUser = serviceHandler.registerUser(username, email, password);
            if (newUser != null) {
                System.out.println("Registration successful for user: " + newUser.getUsername());
                return true;
            } else {
                System.err.println("Registration failed.");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error during registration: " + e.getMessage());
            return false;
        }
    }

    /**
     * Logs in a user by delegating the operation to the ServiceHandler.
     *
     * @param email The email of the user attempting to log in.
     * @param password The password of the user attempting to log in.
     * @return true if login is successful, false otherwise.
     */
    public boolean loginUser(String email, String password) {
        try {
            User loggedInUser = serviceHandler.loginUser(email, password);
            if (loggedInUser != null) {
                this.currentUserId = loggedInUser.getId();
                System.out.println("Login successful for user: " + loggedInUser.getUsername());
                return true;
            } else {
                System.err.println("Invalid email or password.");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error during login: " + e.getMessage());
            return false;
        }
    }
}
