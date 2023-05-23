package com.FindaCar.FindaCarApi.services;

import java.util.ArrayList;

import com.FindaCar.FindaCarApi.entities.Vehicle;

// TODO: Auto-generated Javadoc
/**
 * The Interface VehicleService.
 */
public interface VehicleService {

	/**
	 * Find all vehicles.
	 *
	 * @return the array list
	 */
	public ArrayList<Vehicle> findAllVehicles();

	/**
	 * Find vehicle by owner.
	 *
	 * @param id the id
	 * @return the array list
	 */
	public ArrayList<Vehicle> findVehicleByOwnerId(long id);

	/**
	 * Delete vehicle.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean deleteVehicle(long id);

	/**
	 * Update vehicle.
	 *
	 * @param vehicle the vehicle
	 * @return true, if successful
	 */
	public boolean updateVehicle(Vehicle vehicle);

	/**
	 * Adds the vehicle.
	 *
	 * @param vehicle the vehicle
	 * @return true, if successful
	 */
	public boolean addVehicle(Vehicle vehicle);

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the vehicle
	 */
	public Vehicle findById(long id);

}
