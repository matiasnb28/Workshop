package com.example.PersonalWorkshop.exception;

public class NotLoggedUserException extends RuntimeException{

    public NotLoggedUserException(String message) {
        super(message);
    }
}
