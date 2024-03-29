package com.FindaCar.FindaCarApi.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.FindaCar.FindaCarApi.entities.VehiclePictures;
import com.FindaCar.FindaCarApi.repositories.VehiclePicturesRepository;

@Component
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

	@Override
	public boolean addPicture(VehiclePictures pic) {
		try {
			vpRepo.save(pic);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public boolean deletePictureById(Long id) {
		try {
			vpRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
