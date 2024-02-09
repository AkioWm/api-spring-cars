package com.garage.carsapi.service;

import com.garage.carsapi.model.Car;
import com.garage.carsapi.repository.CarRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public Optional<Car> getCar(final Long id){
        return carRepository.findById(id);
    }

    public Iterable<Car> getCars(){
        return carRepository.findAll();
    }

    public void deleteCar(final Long id){
        carRepository.deleteById(id);
    }

    public Car saveCar(Car car){
        return carRepository.save(car);
    }



}
