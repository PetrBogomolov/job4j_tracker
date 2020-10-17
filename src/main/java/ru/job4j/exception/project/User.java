package ru.job4j.exception.project;

public class User {
    private String userName;
    private boolean valid;

    public User(String userName, boolean valid) {
        this.userName = userName;
        this.valid = valid;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isValid() {
        return valid;
    }
}
