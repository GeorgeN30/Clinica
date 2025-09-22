package com.Gns.clinica.domain.exception;

import java.time.LocalDate;

public class AvailabilityNotFoundByDateException extends RuntimeException {
    public AvailabilityNotFoundByDateException(LocalDate date) {
        super("The Availability with date " + date + " was not found");
    }
}
