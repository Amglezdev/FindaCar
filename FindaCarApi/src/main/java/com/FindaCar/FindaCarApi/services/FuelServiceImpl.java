package com.FindaCar.FindaCarApi.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.FindaCar.FindaCarApi.entities.Fuel;
import com.FindaCar.FindaCarApi.repositories.FuelRepository;

@Component
public class FuelServiceImpl implements FuelService {

	@Autowired
	FuelRepository fr;

	@Override
	public ArrayList<Fuel> getAll() {
		try {
			return (ArrayList<Fuel>) fr.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public Fuel findById(String id) {
		try {
			return fr.findById(id).orElse(null);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public boolean addFuel(Fuel dao) {
		try {
			fr.save(dao);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
