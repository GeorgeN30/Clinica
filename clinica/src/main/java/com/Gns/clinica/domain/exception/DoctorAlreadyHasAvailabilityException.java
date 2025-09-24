package com.Gns.clinica.domain.exception;

import java.time.LocalDate;

public class DoctorAlreadyHasAvailabilityException extends RuntimeException {
    public DoctorAlreadyHasAvailabilityException(String nameDoctor, String lasNameDoctor, LocalDate date) {
        super("The doctor " + nameDoctor + " " + lasNameDoctor + " is already in use" + date);
    }
}
