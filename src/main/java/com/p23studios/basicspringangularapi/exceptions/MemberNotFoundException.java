package com.p23studios.basicspringangularapi.exceptions;

public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(String message) {
        // call the parent constructor
        super(message);
    }
}
