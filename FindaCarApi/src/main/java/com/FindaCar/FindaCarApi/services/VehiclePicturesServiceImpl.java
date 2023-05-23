package com.FindaCar.FindaCarApi.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.FindaCar.FindaCarApi.entities.VehiclePictures;
import com.FindaCar.FindaCarApi.repositories.VehiclePicturesRepository;

public class VehiclePicturesServiceImpl implements VehiclePicturesService {

	@Autowired
	VehiclePicturesRepository vpRepo;

	@Override
	public ArrayList<VehiclePictures> findByVehicleId(long id) {
		try {
			return (ArrayList<VehiclePictures>) vpRepo.findByVehicleId(id);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

}
