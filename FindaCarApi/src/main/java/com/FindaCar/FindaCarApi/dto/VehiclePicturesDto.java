package com.FindaCar.FindaCarApi.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class VehiclePicturesDto.
 */
public class VehiclePicturesDto {
	
	
	/** The id. */
	private long id;
	
	/** The vehicle id. */
	private VehicleDto vehicle;
	
	/** The image. */
	private String image;
	
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
	
	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	public String getImage() {
		return image;
	}
	
	/**
	 * Sets the image.
	 *
	 * @param image the new image
	 */
	public void setImage(String image) {
		this.image = image;
	}
	
	

}
