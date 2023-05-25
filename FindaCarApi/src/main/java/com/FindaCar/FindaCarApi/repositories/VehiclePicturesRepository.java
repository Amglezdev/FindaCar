package com.FindaCar.FindaCarApi.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FindaCar.FindaCarApi.entities.VehiclePictures;

// TODO: Auto-generated Javadoc
/**
 * The Interface VehiclePicturesRepository.
 */
@Repository
public interface VehiclePicturesRepository extends JpaRepository<VehiclePictures, Long> {
//
//	/**
//	 * Gets the all pictures by vehicle.
//	 *
//	 * @param id the id
//	 * @return the all pictures by vehicle
//	 */
//	@Query("SELECT VP FROM VehiclePictures VP WHERE VP.Vehiculo.id = :id")
//	ArrayList<VehiclePictures> getAllPicturesByVehicle(@Param("id") Long id);

	public ArrayList<VehiclePictures> findByVehicleId(long id);
}
