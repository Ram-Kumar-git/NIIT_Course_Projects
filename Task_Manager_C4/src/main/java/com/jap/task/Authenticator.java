package com.jap.task;

import java.util.ArrayList;
import java.util.List;

public class Authenticator {

    // Declare attributes: users - a list of users, authenticatedUser - the currently authenticated user
    private List<User> users;
    private User authenticatedUser;
    // Generate getter and setter methods for both attributes


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setAuthenticatedUser(User authenticatedUser) {
        this.authenticatedUser = authenticatedUser;
    }

    public Authenticator() {
        // Initialize the users list and add a few users
        users = new ArrayList<User>();
        users.add(new User("John","pass1"));
    }

    public User getAuthenticatedUser() {
        // Return the currently authenticated user
        return authenticatedUser;
    }

    /**
     * Authenticates a user with the given username and password.
     *
     * @param username The username to authenticate.
     * @param password The password associated with the username.
     * @return True if authentication is successful, false otherwise.
     */
    public boolean authenticateUser(String username, String password) {
        // Iterate through the users list
        for(User user : users){
            // Check if the given username and password match any user's credentials
            if((user.getUserName().equals(username)) && (user.getPassword().equals(password))){
                authenticatedUser=user;
                return true;
            }
        }

        // If a match is found, assign the user to the authenticatedUser and return true
        return false;
    }

    /**
     * Authenticates a new user with the given username and password.
     *
     * @param username The username of the new user.
     * @param password The password associated with the new user.
     * @return The authenticated user if authentication is successful, null otherwise.
     */
    public User authenticateNewUser(String username, String password) {
        // Call the authenticateUser method to check if the new user's credentials are valid
        if(authenticateUser(username, password)){
            // If the authenticateUser method returns true, return the authenticated user
            System.out.println("Authentication Successful : Welcome "+username);
            return this.authenticatedUser;
        } else {
            System.out.println("Invalid username or password.");
            return null;
        }
    }
}
