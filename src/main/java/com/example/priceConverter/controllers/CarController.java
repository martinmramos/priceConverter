package com.example.priceConverter.controllers;

import com.example.priceConverter.domain.Car;
import com.example.priceConverter.domain.personalExceptions.CarExistsException;
import com.example.priceConverter.domain.personalExceptions.CarNotFoundException;
import com.example.priceConverter.domain.personalExceptions.DateNotFoundException;
import com.example.priceConverter.repositories.CarRepository;
import com.example.priceConverter.repositories.ExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;

@RestController
public class CarController {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ExchangeRepository exchangeRepository;

    @PostMapping("/cars")
    public ResponseEntity<String> addCar(@Valid @RequestBody CarInput car) {
        try {
            if (carRepository.existsById(car.getNumPlate()))
                throw new CarExistsException("Coche existente.");
        } catch (CarExistsException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        carRepository.save(car.toDomain());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/cars/{date}/{numPlate}")
    public ResponseEntity<CarOutput> getCar(@PathVariable Date date, @PathVariable String numPlate) {
        try {
            if (!exchangeRepository.existsById(date))
                throw new DateNotFoundException("No existen datos para esa fecha.");
            if (!carRepository.existsById(numPlate))
                throw new CarNotFoundException("No existe la matrícula que quiere consultar.");
        } catch (DateNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (CarNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
        CarOutput carOutput = new CarOutput();
        Car car = new Car(carRepository.findById(numPlate).get().getNumPlate(), carRepository.findById(numPlate).get().getBrand(), carRepository.findById(numPlate).get().getPriceEuros());
        carOutput.setNumPlate(car.getNumPlate());
        carOutput.setBrand(car.getBrand());
        carOutput.setPriceEuros(car.getPriceEuros());
        carOutput.setPriceDolares(car.getPriceEuros() * exchangeRepository.findById(date).get().getDolar());
        carOutput.setPriceLibras(car.getPriceEuros() * exchangeRepository.findById(date).get().getLibra());
        return ResponseEntity.ok(carOutput);
    }
}
