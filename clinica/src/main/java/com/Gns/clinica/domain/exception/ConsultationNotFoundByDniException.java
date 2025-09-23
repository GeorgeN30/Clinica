package com.Gns.clinica.domain.exception;

public class ConsultationNotFoundByDniException extends RuntimeException {
    public ConsultationNotFoundByDniException(String dni) {
        super("The consultation with dni " + dni + " was not found");
    }
}
