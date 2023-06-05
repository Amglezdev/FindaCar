package com.FindaCar.FindaCarApi.services;

import java.util.ArrayList;

import com.FindaCar.FindaCarApi.entities.VehicleType;

// TODO: Auto-generated Javadoc
/**
 * The Interface VehicleTypeService.
 */
public interface VehicleTypeService {

	/**
	 * Find all vehicle types.
	 *
	 * @return the array list
	 */
	public ArrayList<VehicleType> findAllVehicleTypes();

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the vehicle type
	 */
	public VehicleType findById(String id);

	/**
	 * Adds the type.
	 *
	 * @param dao the dao
	 * @return true, if successful
	 */
	public boolean addType(VehicleType dao);

}
