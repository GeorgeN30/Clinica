package com.Gns.clinica.domain.exception;

public class UserNotFoundByDniException extends RuntimeException {
    public UserNotFoundByDniException(String dni) {
        super("The user with DNI  " + dni + " was not found");
    }
}
