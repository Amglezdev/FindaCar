package com.FindaCar.FindaCarApi.services;

import java.util.ArrayList;

import com.FindaCar.FindaCarApi.entities.VehiclePictures;

public interface VehiclePicturesService{

	/**
	 * Find by vehicle id.
	 *
	 * @param id the id
	 * @return the array list
	 */
	public ArrayList<VehiclePictures> findByVehicleId(long id);

}
