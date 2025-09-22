package com.Gns.clinica.domain.exception;

public class AvailabilityNotFoundException extends RuntimeException {
    public AvailabilityNotFoundException(long id) {
        super("The Availability with id " + id + " does not exist");
    }
}
