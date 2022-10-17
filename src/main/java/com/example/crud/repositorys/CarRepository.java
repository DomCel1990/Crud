package com.example.crud.repositorys;

import com.example.crud.entitis.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
