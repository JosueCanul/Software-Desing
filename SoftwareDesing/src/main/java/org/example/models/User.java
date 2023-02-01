package org.example.models;

public class User {

    private String email;

    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return email + "," + password;
    }
}
