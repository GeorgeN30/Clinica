package com.Gns.clinica.domain.exception;

public class UserNotFoundByEmailException extends RuntimeException {
    public UserNotFoundByEmailException(String email) {
        super("The user with email " + email + " was not found");
    }
}
