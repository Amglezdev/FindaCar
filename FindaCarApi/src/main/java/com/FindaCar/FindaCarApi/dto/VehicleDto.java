package com.FindaCar.FindaCarApi.dto;

import java.util.Calendar;

// TODO: Auto-generated Javadoc
/**
 * The Class VehicleDto.
 */
public class VehicleDto {
	
	/** The id. */
	private long id;
	
	/** The brand. */
	private String brand;
	
	/** The model. */
	private String model;
	
	/** The power. */
	private int power;
	
	/** The type id. */
	private long typeId;
	
	/** The age. */
	private Calendar age;
	
	/** The mileage. */
	private int mileage;
	
	/** The user id. */
	private long userId;
	
	/** The price. */
	private double price;
	
	/**
	 * Gets the mileage.
	 *
	 * @return the mileage
	 */
	public int getMileage() {
		return mileage;
	}

	/**
	 * Sets the mileage.
	 *
	 * @param mileage the new mileage
	 */
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}	
	
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
	 * Gets the brand.
	 *
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	
	/**
	 * Sets the brand.
	 *
	 * @param brand the new brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	
	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	public void setModel(String model) {
		this.model = model;
	}
	
	/**
	 * Gets the power.
	 *
	 * @return the power
	 */
	public int getPower() {
		return power;
	}
	
	/**
	 * Sets the power.
	 *
	 * @param power the new power
	 */
	public void setPower(int power) {
		this.power = power;
	}
	
	/**
	 * Gets the type id.
	 *
	 * @return the type id
	 */
	public long getTypeId() {
		return typeId;
	}
	
	/**
	 * Sets the type id.
	 *
	 * @param typeId the new type id
	 */
	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	
	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public Calendar getAge() {
		return age;
	}
	
	/**
	 * Sets the age.
	 *
	 * @param age the new age
	 */
	public void setAge(Calendar age) {
		this.age = age;
	}
	
	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public long getUserId() {
		return userId;
	}
	
	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
