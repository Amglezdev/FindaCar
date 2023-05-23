package com.FindaCar.FindaCarApi.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FindaCar.FindaCarApi.entities.Vehicle;

/**
 * The Interface VehicleRepository.
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

	/**
	 * Find by owner id.
	 *
	 * @return the array list
	 */
	public ArrayList<Vehicle> findByOwnerId(long id);
}
