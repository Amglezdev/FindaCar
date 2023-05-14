package com.FindaCar.FindaCarApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FindaCar.FindaCarApi.entities.Vehicle;

/**
 * The Interface VehicleRepository.
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

}
