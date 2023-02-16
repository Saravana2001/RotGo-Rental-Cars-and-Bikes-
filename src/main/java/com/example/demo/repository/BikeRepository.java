package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Bike;

public interface BikeRepository extends JpaRepository<Bike, Integer> {
	@Query("SELECT b FROM Bike b WHERE b.brand LIKE %?1%"
            + " OR b.model LIKE %?1%"
            + " OR b.fuelType LIKE %?1%"
            + " OR b.year LIKE %?1%")
    public List<Bike> search(String keyword);
}
