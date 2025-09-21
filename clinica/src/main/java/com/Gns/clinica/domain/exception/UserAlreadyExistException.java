package com.Gns.clinica.domain.exception;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String userDni) {
        super("The user with DNI " + userDni + " already exist");
    }
}
