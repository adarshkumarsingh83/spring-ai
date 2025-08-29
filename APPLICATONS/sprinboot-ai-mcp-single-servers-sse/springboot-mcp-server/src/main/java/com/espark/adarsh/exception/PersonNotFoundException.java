package com.espark.adarsh.exception;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(String employeeNotFound) {
        super(employeeNotFound);
    }
}
