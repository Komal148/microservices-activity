package com.stackroute.Exceptions;

public class UserAlreadyFoundException extends Exception {

    private String message;

    public UserAlreadyFoundException() {
    }


    public UserAlreadyFoundException(String message) {
        super(message);
        this.message = message;
    }
}
