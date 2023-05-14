package com.FindaCar.FindaCarApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FindaCar.FindaCarApi.entities.Post;

// TODO: Auto-generated Javadoc
/**
 * The Interface PostRepository.
 */
public interface PostRepository extends JpaRepository<Post, Long>{
//	
//	/**
//	 * Find by car power.
//	 *
//	 * @param power the power
//	 * @return the array list
//	 */
//	@Query("SELECT p FROM Post p WHERE p.vehicle.power = :power")
//    ArrayList<Post> findByCarPower(@Param("power") int power);
//	
//	/**
//	 * Finds a post which vehicle´s brand is equal to the one given.
//	 *
//	 * @param brand the brand
//	 * @return the array list
//	 */
//	@Query("SELECT p FROM Post p WHERE p.vehicle.brand = :brand")
//	ArrayList<Post> findByVehicleBrand(@Param("brand") String brand);
//	
//	/**
//	 * Find a post which vehicle´s mileage is equal to the one given.
//	 *
//	 * @param mileage the mileage
//	 * @return the array list
//	 */
//	@Query("SELECT p FROM Post WHERE p.vehicle.mileage = :mileage")
//	ArrayList<Post> findByVehicleMileage(@Param("mileage")double mileage);
//	
//	/**
//	 * Finds a post which vehicle´s age is equal to the one given.
//	 *
//	 * @param age the age
//	 * @return the array list
//	 */
//	@Query("Select p FROM Post where p.vehicle.age < :age")
//	ArrayList<Post> findByVehicleAge(@Param("age")Calendar age);

}
