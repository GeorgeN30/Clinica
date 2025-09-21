package com.Gns.clinica.domain.exception;

public class BranchNotFoundByIdException extends RuntimeException {
    public BranchNotFoundByIdException(long id) {
        super("The branch with id " + id + " was not found");
    }
}
