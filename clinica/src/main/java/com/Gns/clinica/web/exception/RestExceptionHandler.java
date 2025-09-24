package com.Gns.clinica.web.exception;


import com.Gns.clinica.domain.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<Error> handleException(UserAlreadyExistException exception){
        Error error = new Error("user-already-exists", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Error> handleException(EmailAlreadyExistsException exception){
        Error error = new Error("email-already-exists", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(UserNotFoundByDniException.class)
    public ResponseEntity<Error> handleException(UserNotFoundByDniException exception){
        Error error = new Error("user-not-found", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(UserNotFoundByEmailException.class)
    public ResponseEntity<Error> handleException(UserNotFoundByEmailException exception){
        Error error = new Error("user-not-found", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(UserNotFoundByIdException.class)
    public ResponseEntity<Error> handleException(UserNotFoundByIdException exception){
        Error error = new Error("user-not-found", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(SpecialtyAlreadyExistsException.class)
    public ResponseEntity<Error> handleException(SpecialtyAlreadyExistsException exception){
        Error error = new Error("specialty-already-exists", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(SpecialtyNotFoundByIdException.class)
    public ResponseEntity<Error> handleException(SpecialtyNotFoundByIdException exception){
        Error error = new Error("specialty-not-found", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(SpecialtyNotFoundByNameException.class)
    public ResponseEntity<Error> handleException(SpecialtyNotFoundByNameException exception){
        Error error = new Error("specialty-not-found", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(BranchAlreadyExistsException.class)
    public ResponseEntity<Error> handleException(BranchAlreadyExistsException exception){
        Error error = new Error("branch-already-exists", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(BranchNotFoundByIdException.class)
    public ResponseEntity<Error> handleException(BranchNotFoundByIdException exception){
        Error error = new Error("branch-not-found", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(BranchNotFoundByNameException.class)
    public ResponseEntity<Error> handleException(BranchNotFoundByNameException exception){
        Error error = new Error("branch-not-found", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(AvailabilityInvalidDateException.class)
    public ResponseEntity<Error> handleException(AvailabilityInvalidDateException exception){
        Error error = new Error("availability-invalid-date", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(AvailabilityNotFoundByDateException.class)
    public ResponseEntity<Error> handleException(AvailabilityNotFoundByDateException exception){
        Error error = new Error("availability-not-found-by-date", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(AvailabilityNotFoundException.class)
    public ResponseEntity<Error> handleException(AvailabilityNotFoundException exception){
        Error error = new Error("availability-not-found", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(AvailabilityInvalidStatusException.class)
    public ResponseEntity<Error> handleException(AvailabilityInvalidStatusException exception){
        Error error = new Error("availability-invalid-status", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(DoctorNotFoundByDniException.class)
    public ResponseEntity<Error> handleException(DoctorNotFoundByDniException exception){
        Error error = new Error("doctor-not-found-by-dni", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(ReservationNotFoundByDniException.class)
    public ResponseEntity<Error> handleException(ReservationNotFoundByDniException exception){
        Error error = new Error("reservation-not-found-by-dni", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(ReservationNotFoundByIdException.class)
    public ResponseEntity<Error> handleException(ReservationNotFoundByIdException exception){
        Error error = new Error("reservation-not-found-by-id", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(ConsultationNotFoundByDniException.class)
    public ResponseEntity<Error> handleException(ConsultationNotFoundByDniException exception){
        Error error = new Error("consultation-not-found-by-dni", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(ConsultationNotFoundByIdException.class)
    public ResponseEntity<Error> handleException(ConsultationNotFoundByIdException exception){
        Error error = new Error("consultation-not-found-by-id", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DoctorReachedDailyReservationLimitException.class)
    public ResponseEntity<Error> handleException(DoctorReachedDailyReservationLimitException exception){
        Error error = new Error("doctor-reached-max-limit-reservation", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(SpecialtyReachedDailyReservationException.class)
    public ResponseEntity<Error> handleException(SpecialtyReachedDailyReservationException exception){
        Error error = new Error("specialty-reached-max-limit-reservation", exception.getMessage());
        return ResponseEntity.badRequest().body(error);
    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
