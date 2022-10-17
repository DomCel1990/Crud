package com.example.crud.controllers;

import com.example.crud.entitis.Car;
import com.example.crud.repositorys.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("deprecated")
@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarRepository carRepository;

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        Car carCreated = carRepository.saveAndFlush(car);
        return carCreated;
    }

    @GetMapping
    public List<Car> getCars() {
        List<Car> cars = carRepository.findAll();
        return cars;
    }

    @GetMapping("/{id}")
    public Car getCar(@PathVariable long id) {
        Car car = carRepository.getById(id);
        if (!carRepository.existsById(id)) {
            return new Car();
        } else
            return car;
    }

    @PutMapping("/{id}")
    public Car updateCar(@PathVariable long id, @RequestBody Car car) {
        if (carRepository.existsById(id)) {
            car.setId(id);
            Car carUpdate = carRepository.saveAndFlush(car);
            return carUpdate;
        } else return new Car();
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable long id) throws Exception {
        if (!carRepository.existsById(id))
         throw new Exception(String.valueOf(HttpStatus.CONFLICT));
        else
            carRepository.deleteById(id);
    }

    @DeleteMapping
    public void deleteCars() {
        carRepository.deleteAll();
    }
}

