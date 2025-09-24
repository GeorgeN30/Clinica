package com.Gns.clinica.domain.exception;

public class SpecialtyReachedDailyReservationException extends RuntimeException {
    public SpecialtyReachedDailyReservationException() {
        super("The specialty reached daily reservations limit max 3");
    }
}
