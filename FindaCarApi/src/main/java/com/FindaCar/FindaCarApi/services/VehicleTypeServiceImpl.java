package com.FindaCar.FindaCarApi.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.FindaCar.FindaCarApi.entities.VehicleType;
import com.FindaCar.FindaCarApi.repositories.VehicleTypeRepository;

@Component
public class VehicleTypeServiceImpl implements VehicleTypeService {

	@Autowired
	VehicleTypeRepository vtRepo;

	@Override
	public ArrayList<VehicleType> findAllVehicleTypes() {
		try {
			return (ArrayList<VehicleType>)vtRepo.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public VehicleType findById(String id) {
		try {
			return vtRepo.findById(id).orElse(null);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public boolean addType(VehicleType dao) {
		try {
			vtRepo.save(dao);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
