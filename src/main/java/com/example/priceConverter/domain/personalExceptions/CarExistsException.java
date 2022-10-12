package com.example.priceConverter.domain.personalExceptions;

public class CarExistsException extends Exception{

    public CarExistsException(String message) {
        super(message);
    }
}
