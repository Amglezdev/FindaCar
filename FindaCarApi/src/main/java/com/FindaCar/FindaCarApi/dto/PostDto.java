package com.FindaCar.FindaCarApi.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class PostDto.
 */
public class PostDto {

	/** The id. */
	private long id;

	/** The vehicle . */
	private VehicleDto vehicle;

	/** The comment. */
	private String comment;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	

	@Override
	public String toString() {
		return "PostDto [id=" + id + ", vehicle=" + vehicle + ", comment=" + comment + "]";
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
	 * Gets the comment.
	 *
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Sets the comment.
	 *
	 * @param comment the new comment
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

}
