package com.Gns.clinica.domain.exception;

public class DoctorNotFoundByDniException extends RuntimeException {
    public DoctorNotFoundByDniException(String dni) {
        super("The doctor with id " + dni + " was not found");
    }
}
