package com.peerlearn.peerlearn.errors.exceptions;

public class UserPasswordNotMatchException extends RuntimeException{
    public UserPasswordNotMatchException(String message) {
        super(message);
    }
}
