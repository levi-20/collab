package com.cs.collabcall.exceptions;


public class UserNotFoundException extends NotFoundException {

    public UserNotFoundException() {

        super("user not found");
    }
}
