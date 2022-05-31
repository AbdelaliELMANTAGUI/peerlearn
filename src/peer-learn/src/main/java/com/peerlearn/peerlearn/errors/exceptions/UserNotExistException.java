package com.peerlearn.peerlearn.errors.exceptions;

public class UserNotExistException extends RuntimeException{
    public UserNotExistException(String message) {
        super(message);
    }
}
