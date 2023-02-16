package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Bike;
import com.example.demo.model.Car;
import com.example.demo.repository.BikeRepository;
import com.example.demo.repository.OwnerRepository;
@Service
public class BikeService {
	@Autowired
	private BikeRepository repo;
	@Autowired
	private OwnerRepository orepo;
	
	public List<Bike> listAl(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }
	
	public List<Bike> listAll() {
		return repo.findAll();
	}
	
	public Bike get(int id) {
		return repo.findById(id).get();
	}
	
	public void save(Bike bike) {
		repo.save(bike);
	}
	
	public void deleteAll(Bike bike)
	{
		repo.delete(bike);
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	public void deleteAl()
	{
		repo.deleteAll();
	}
}
