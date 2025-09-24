package com.Gns.clinica.domain.exception;

public class DoctorReachedDailyReservationLimitException extends RuntimeException {
    public DoctorReachedDailyReservationLimitException(String name, String lasName) {
        super("The doctor reached daily reservations limit max of 3 for doctor " + name + " "+ lasName);
    }
}
