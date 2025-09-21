package com.Gns.clinica.domain.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String email) {
        super("The user with email " + email + " already exist");
    }
}
