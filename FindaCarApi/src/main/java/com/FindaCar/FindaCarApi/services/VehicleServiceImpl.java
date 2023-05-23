package com.FindaCar.FindaCarApi.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.FindaCar.FindaCarApi.entities.Vehicle;
import com.FindaCar.FindaCarApi.repositories.VehicleRepository;

@Component
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleRepository vehicleRepo;

	@Override
	public ArrayList<Vehicle> findAllVehicles() {
		try {
			return (ArrayList<Vehicle>) vehicleRepo.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public ArrayList<Vehicle> findVehicleByOwnerId(long id) {
		try {
			return (ArrayList<Vehicle>) vehicleRepo.findByOwnerId(id);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	@Override
	public boolean deleteVehicle(long id) {
		try {
			vehicleRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean updateVehicle(Vehicle vehicle) {
		try {
			vehicleRepo.save(vehicle);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	@Override
	public boolean addVehicle(Vehicle vehicle) {
		try {
			vehicleRepo.save(vehicle);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Vehicle findById(long id) {
		try {
			return vehicleRepo.findById(id).orElse(null);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
