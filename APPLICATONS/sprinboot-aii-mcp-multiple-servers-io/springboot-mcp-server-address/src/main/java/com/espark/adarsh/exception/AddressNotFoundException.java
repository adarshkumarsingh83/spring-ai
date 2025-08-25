package com.espark.adarsh.exception;

public class AddressNotFoundException extends RuntimeException {
    public AddressNotFoundException(String employeeNotFound) {
        super(employeeNotFound);
    }
}
