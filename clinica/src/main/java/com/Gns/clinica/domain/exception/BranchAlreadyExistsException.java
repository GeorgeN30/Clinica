package com.Gns.clinica.domain.exception;

public class BranchAlreadyExistsException extends RuntimeException {
    public BranchAlreadyExistsException(String name) {
        super("The branch with name " + name + " already exists");
    }
}
