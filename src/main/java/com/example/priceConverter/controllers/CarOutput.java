package com.example.priceConverter.controllers;

public class CarOutput extends CarInput {

    private double priceDolares;
    private double priceLibras;

    public CarOutput(String numPlate, String brand, double priceEuros, double dolares, double libras) {
        super(numPlate, brand, priceEuros);
        this.priceDolares = dolares;
        this.priceLibras = libras;
    }

    public CarOutput() {
    }

    public double getPriceDolares() {
        return priceDolares;
    }

    public void setPriceDolares(double priceDolares) {
        this.priceDolares = priceDolares;
    }

    public double getPriceLibras() {
        return priceLibras;
    }

    public void setPriceLibras(double priceLibras) {
        this.priceLibras = priceLibras;
    }
}
