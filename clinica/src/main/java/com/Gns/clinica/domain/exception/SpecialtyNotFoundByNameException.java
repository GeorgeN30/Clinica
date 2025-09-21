package com.Gns.clinica.domain.exception;

public class SpecialtyNotFoundByNameException extends RuntimeException {
    public SpecialtyNotFoundByNameException(String name) {
        super("The specialty with name " + name + " was not found");
    }
}
