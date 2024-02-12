package com.garage.carsapi.controller;

import com.garage.carsapi.model.Car;
import com.garage.carsapi.service.CarService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@Data
@RestController
public class CarController {
    @Autowired
    private CarService carService;
    @GetMapping("/cars")
    public Iterable<Car> getCars(){
        return carService.getCars();
    }
    @PostMapping("/cars")
    public Car createCar(@RequestBody Car car){
        return  carService.saveCar(car);
    }
}
