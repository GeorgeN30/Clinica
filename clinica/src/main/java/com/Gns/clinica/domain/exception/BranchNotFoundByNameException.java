package com.Gns.clinica.domain.exception;

public class BranchNotFoundByNameException extends RuntimeException {
    public BranchNotFoundByNameException(String name) {
        super("The branch with name " + name + " was not found");
    }
}
