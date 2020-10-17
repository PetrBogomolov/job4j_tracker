package ru.job4j.exception.project;

public class UserInvalidException extends  UserNotFoundException {
    public UserInvalidException(String message) {
        super(message);
    }
}
