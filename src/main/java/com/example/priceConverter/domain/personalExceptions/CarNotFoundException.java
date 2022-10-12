package com.example.priceConverter.domain.personalExceptions;

public class CarNotFoundException extends Exception {
    public CarNotFoundException(String message) {
        super(message);
    }
}
