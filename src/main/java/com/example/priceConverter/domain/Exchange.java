package com.example.priceConverter.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity(name = "exchange")
public class Exchange {

    @Id
    @NotBlank
    @NotNull
    private Date date;
    @Digits(integer = 9, fraction = 2)
    private double euro, dolar, libra;

    public Exchange(Date date, double euro, double dolar, double libra) {
        this.date = date;
        this.euro = euro;
        this.dolar = dolar;
        this.libra = libra;
    }

    public Exchange() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getEuro() {
        return euro;
    }

    public void setEuro(double euro) {
        this.euro = euro;
    }

    public double getDolar() {
        return dolar;
    }

    public void setDolar(double dolar) {
        this.dolar = dolar;
    }

    public double getLibra() {
        return libra;
    }

    public void setLibra(double libra) {
        this.libra = libra;
    }
}
