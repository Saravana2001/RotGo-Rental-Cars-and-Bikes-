package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Bike;
import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.OwnerAddressRepository;
import com.example.demo.repository.OwnerRepository;

@Service
public class CarService {
	@Autowired
	private CarRepository repo;
	@Autowired
	private OwnerRepository orepo;
	@Autowired
	private OwnerAddressRepository oarepo;
	
	public List<Car> listAl(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }
	
	public List<Car> listAll() {	
		return repo.findAll();
	}
	
	public void save(Car car) {
		repo.save(car);
	}
	
	public Car get(int id) {
		return repo.findById(id).get();
	}
	
	public void deleteAl()
	{
		repo.deleteAll();
	}
	
	public void deleteAll(Car car)
	{
		repo.delete(car);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
