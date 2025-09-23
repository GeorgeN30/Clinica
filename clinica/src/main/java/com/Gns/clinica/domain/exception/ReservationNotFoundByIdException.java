package com.Gns.clinica.domain.exception;

public class ReservationNotFoundByIdException extends RuntimeException {
    public ReservationNotFoundByIdException(long id) {
        super("The reservation with id " + id + " was not found");
    }
}
