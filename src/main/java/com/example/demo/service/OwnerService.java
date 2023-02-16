package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Owner;
import com.example.demo.repository.OwnerAddressRepository;
import com.example.demo.repository.OwnerRepository;

@Service
public class OwnerService {
	@Autowired
	private OwnerRepository repo;
	@Autowired
	private OwnerAddressRepository oar;
	
	public List<Owner> listAll() {	
		return repo.findAll();
	}
	
	public void save(Owner owner) {
		repo.save(owner);
	}
	
	public Owner get(int id) {
		return repo.findById(id).get();
	}
	
	public Optional<Owner> findById(int id) {
		return repo.findById(id);
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}

	public void deleteAl()
	{
		repo.deleteAll();
	}
}
