package com.garage.carsapi.controller;

import com.garage.carsapi.model.Car;
import com.garage.carsapi.service.CarService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Data
@RestController
public class CarController {
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public Iterable<Car> getCars(){
        return carService.getCars();
    }
    @GetMapping("/car/{id}")
    public Car getCar(@PathVariable("id") final Long id) {
        Optional<Car> car = carService.getCar(id);
        if(car.isPresent()) {
            return car.get();
        } else {
            return null;
        }
    }
    @PutMapping("/car/{id}")
    public Car updateCar(@PathVariable("id") final Long id, @RequestBody Car car) {
        Optional<Car> c = carService.getCar(id);
        if(c.isPresent()) {
            Car currentCar = c.get();
            String makeName = car.getMakeName();
            if (makeName != null){
                currentCar.setMakeName(makeName);
            }
            String modelName = car.getModelName();
            if(modelName != null){
                currentCar.setModelName(modelName);
            }
            int horsepower = car.getHorsePower();
            if(horsepower != 0){
                currentCar.setHorsePower(horsepower);
            }
            int retailPrice = car.getRetailPrice();
            if(retailPrice != 0){
                currentCar.setRetailPrice(retailPrice);
            }
            carService.saveCar(currentCar);
            return currentCar;
        } else {
            return null;
        }
    }
    @PostMapping("/car")
    public Car createCar(@RequestBody Car car){
        return  carService.saveCar(car);
    }

    @DeleteMapping("/car/{id}")
    public void deleteCar(@PathVariable("id") final Long id) {
        carService.deleteCar(id);
    }
}
