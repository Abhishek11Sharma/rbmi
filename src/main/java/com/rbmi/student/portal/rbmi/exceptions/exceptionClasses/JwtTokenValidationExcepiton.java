package com.rbmi.student.portal.rbmi.exceptions.exceptionClasses;
public class JwtTokenValidationExcepiton extends RuntimeException {

    public JwtTokenValidationExcepiton() {
        super("Jwt token validation exception");
    }

    public JwtTokenValidationExcepiton(String message) {
        super(message);
    }
}