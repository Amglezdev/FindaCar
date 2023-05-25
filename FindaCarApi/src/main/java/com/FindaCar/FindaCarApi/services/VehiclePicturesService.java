package com.FindaCar.FindaCarApi.services;

import java.util.ArrayList;

import com.FindaCar.FindaCarApi.entities.VehiclePictures;

// TODO: Auto-generated Javadoc
/**
 * The Interface VehiclePicturesService.
 */
public interface VehiclePicturesService{

	/**
	 * Find by vehicle id.
	 *
	 * @param id the id
	 * @return the array list
	 */
	public ArrayList<VehiclePictures> findByVehicleId(long id);
	
	/**
	 * Adds the picture.
	 *
	 * @param pic the pic
	 * @return true, if successful
	 */
	public boolean addPicture(VehiclePictures pic);
	
	/**
	 * Delete picture by id.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean deletePictureById(Long id);
	
	

}
