package com.example.priceConverter.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity(name = "cars")
public class Car {

    @NotBlank(message = "Number plate is empty.")
    @NotNull(message = "Numbre plate is null.")
    @Size(min = 1, max = 8)
    @Id
    private String numPlate;
    @NotBlank(message = "Brand is empty.")
    @NotNull(message = "Brand is null.")
    private String brand;
    @Digits(integer = 9, fraction = 2)
    @Min(1)
    private double priceEuros;

    public Car(String numPlate, String brand, double priceEuros) {
        this.numPlate = numPlate;
        this.brand = brand;
        this.priceEuros = priceEuros;
    }

    public Car() {
    }

    public String getNumPlate() {
        return numPlate;
    }

    public void setNumPlate(String numPlate) {
        this.numPlate = numPlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPriceEuros() {
        return priceEuros;
    }

    public void setPriceEuros(double priceEuros) {
        this.priceEuros = priceEuros;
    }
}
