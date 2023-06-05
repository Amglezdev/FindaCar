package com.FindaCar.FindaCarApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FindaCar.FindaCarApi.entities.Fuel;

/**
 * The Interface FuelRepository.
 */
@Repository
public interface FuelRepository extends JpaRepository<Fuel, String> {

}
