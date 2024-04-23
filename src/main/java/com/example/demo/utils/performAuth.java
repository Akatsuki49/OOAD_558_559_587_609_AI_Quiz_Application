package com.example.demo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class performAuth {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/springdb";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "root";
    // private static final String DB_PASSWORD = "admin";

    private String userName;
    private String password;
    private boolean isSignUp;

    public boolean getIsSignUp() {
        return isSignUp;
    }

    public void setIsSignUp(boolean isSignUp) {
        this.isSignUp = isSignUp;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean authenticate() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
            if (!isSignUp) {
                System.out.println("Attempting to sign up...");
                return signUp(connection);
            } else {
                System.out.println("Attempting to sign in...");
                return signIn(connection);
            }
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
            return false;
        }
    }

    private boolean signUp(Connection connection) throws SQLException {
        String query = "INSERT INTO users (username, password) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, password);
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Sign up successful");
            return true;
        } else {
            System.out.println("Sign up failed");
            return false;
        }
    }

    private boolean signIn(Connection connection) throws SQLException {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("Sign in successful");
            return true;
        } else {
            System.out.println("Sign in failed");
            return false;
        }
    }
}
