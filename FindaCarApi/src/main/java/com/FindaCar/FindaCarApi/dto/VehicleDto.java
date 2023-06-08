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
	private VehicleTypeDto type;
	
	/** The age. */
	private Calendar age;
	
	/** The mileage. */
	private int mileage;
	
	/** The user id. */
	private UserDto owner;
	
	/** The price. */
	private double price;
	
	/** The fuel. */
	private FuelDto fuel;
	
	/**
	 * Gets the mileage.
	 *
	 * @return the mileage
	 */
	public int getMileage() {
		return mileage;
	}

	public UserDto getOwner() {
		return owner;
	}

	public void setOwner(UserDto owner) {
		this.owner = owner;
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
	public VehicleTypeDto getType() {
		return type;
	}
	
	/**
	 * Sets the type id.
	 *
	 * @param type the new type
	 */
	public void setType(VehicleTypeDto type) {
		this.type = type;
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

	/**
	 * Gets the fuel.
	 *
	 * @return the fuel
	 */
	public FuelDto getFuel() {
		return fuel;
	}

	/**
	 * Sets the fuel.
	 *
	 * @param fuel the new fuel
	 */
	public void setFuel(FuelDto fuel) {
		this.fuel = fuel;
	}
	
	

}
