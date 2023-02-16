package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.OwnerAddress;
import com.example.demo.repository.OwnerAddressRepository;

public class OwnerAddressService {
	@Autowired
	private OwnerAddressRepository repo;
	
	public List<OwnerAddress> listAll() {	
		return repo.findAll();
	}
	
	public void save(OwnerAddress oaddress) {
		repo.save(oaddress);
	}
	
	public OwnerAddress get(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
}
