package com.Gns.clinica.domain.exception;

public class ConsultationNotFoundByIdException extends RuntimeException {
    public ConsultationNotFoundByIdException(long id) {
        super("The consultation with id " + id + " was not found");
    }
}
