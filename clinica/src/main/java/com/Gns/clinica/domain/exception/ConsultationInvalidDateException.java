package com.Gns.clinica.domain.exception;

public class ConsultationInvalidDateException extends RuntimeException {
    public ConsultationInvalidDateException() {
        super("Date must be equal availability date");
    }
}
