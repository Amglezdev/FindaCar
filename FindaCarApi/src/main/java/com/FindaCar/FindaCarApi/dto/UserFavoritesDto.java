package com.FindaCar.FindaCarApi.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class UserFavorites.
 */
public class UserFavoritesDto {
	
	/** The id. */
	private long id;
	
	/** The user id. */
	private UserDto user;
	
	/** The vehicle id. */
	private VehicleDto vehicle;
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public UserDto getUser() {
		return user;
	}
	
	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUser(UserDto user) {
		this.user = user;
	}
	
	/**
	 * Gets the vehicle id.
	 *
	 * @return the vehicle id
	 */
	public VehicleDto getVehicle() {
		return vehicle;
	}
	
	/**
	 * Sets the vehicle id.
	 *
	 * @param vehicleId the new vehicle id
	 */
	public void setVehicle(VehicleDto vehicle) {
		this.vehicle = vehicle;
	}
	
	

}
