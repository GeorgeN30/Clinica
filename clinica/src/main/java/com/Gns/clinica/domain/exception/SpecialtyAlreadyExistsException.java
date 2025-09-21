package com.Gns.clinica.domain.exception;

public class SpecialtyAlreadyExistsException extends RuntimeException {
    public SpecialtyAlreadyExistsException(String name) {
        super("The specialty with name " + name + " already exists");
    }
}
