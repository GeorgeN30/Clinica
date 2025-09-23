package com.Gns.clinica.domain.exception;

public class ReservationNotFoundByDniException extends RuntimeException {
    public ReservationNotFoundByDniException(String dni) {
        super("Reservation not found by dni: " + dni);
    }
}
