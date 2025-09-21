package com.Gns.clinica.domain.exception;

public class UserNotFoundByIdException extends RuntimeException {
    public UserNotFoundByIdException(long id) {
        super("The user with id" + id + " not found");
    }
}
