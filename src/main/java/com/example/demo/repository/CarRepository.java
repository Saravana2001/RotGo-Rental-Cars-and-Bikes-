package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

	@Query("SELECT c FROM Car c WHERE c.brand LIKE %?1%"
            + " OR c.model LIKE %?1%"
            + " OR c.fuelType LIKE %?1%"
            + " OR c.year LIKE %?1%")
    public List<Car> search(String keyword);
}
