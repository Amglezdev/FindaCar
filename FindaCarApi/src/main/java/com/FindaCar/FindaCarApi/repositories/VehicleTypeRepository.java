package com.FindaCar.FindaCarApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FindaCar.FindaCarApi.entities.VehicleType;

/**
 * The Interface VehicleTypeRepository.
 */
@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType, String>{

}
