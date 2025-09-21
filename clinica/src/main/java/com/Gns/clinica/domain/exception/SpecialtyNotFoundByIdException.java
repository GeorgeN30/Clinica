package com.Gns.clinica.domain.exception;

public class SpecialtyNotFoundByIdException extends RuntimeException {
    public SpecialtyNotFoundByIdException(long id) {
        super("The Specialty with id " + id + " was not found");
    }
}
