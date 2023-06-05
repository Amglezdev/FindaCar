package com.FindaCar.FindaCarApi.services;

import java.util.ArrayList;

import com.FindaCar.FindaCarApi.entities.Fuel;

// TODO: Auto-generated Javadoc
/**
 * The Interface FuelService.
 */
public interface FuelService {

	/**
	 * Gets the all.
	 *
	 * @return the all
	 */
	public ArrayList<Fuel> getAll();

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the fuel
	 */
	public Fuel findById(String id);

	/**
	 * Adds the fuel.
	 *
	 * @param dao the dao
	 * @return true, if successful
	 */
	public boolean addFuel(Fuel dao);

}
