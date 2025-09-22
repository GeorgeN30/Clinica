package com.Gns.clinica.domain.exception;

import java.time.LocalDate;

public class AvailabilityInvalidDateException extends RuntimeException {
    public AvailabilityInvalidDateException(LocalDate date) {
        super("The date " + date + " cannot be in the past.");
    }
}
