package com.Gns.clinica.domain.exception;

public class AvailabilityInvalidStatusException extends RuntimeException {
    public AvailabilityInvalidStatusException(long id) {
        super("The availability status by id " + id + " is invalid");
    }
}
