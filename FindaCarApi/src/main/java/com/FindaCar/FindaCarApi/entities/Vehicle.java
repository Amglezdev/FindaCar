package com.FindaCar.FindaCarApi.entities;


import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class Vehicle.
 */
@Entity
@Table(name = "fac_da_Vehiculos", schema = "sc_findacar_datos_aplicacion")
public class Vehicle {

	/** The md uuid. */
	@Column(name = "md_uuid")
	private String mdUuid;

	/** The md date. */
	@Column(name = "md_date")
	private Calendar mdDate;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** The marca. */
	@Column(name = "marca")
	private String brand; // Probably needs a catalog table

	/** The model. */
	@Column(name = "modelo")
	private String model;

	/** The power. */
	@Column(name = "potencia")
	private int power;

	/** The mileage. */
	@Column(name = "kilometraje")
	private int mileage;

	/** The type. */	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_vehiculo")
	private VehicleType type;

	/** The age. */
	@Column(name = "fecha_matriculacion")
	private Calendar age;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_combustible")
	private Fuel fuel;

	/** The owner. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "propietario")
	private User owner;

	/** The price. */
	@Column(name = "precio")
	private double price;
	
	@OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Post> posts;

	/**
	 * Gets the md uuid.
	 *
	 * @return the md uuid
	 */
	public String getMdUuid() {
		return mdUuid;
	}

	/**
	 * Sets the md uuid.
	 *
	 * @param mdUuid the new md uuid
	 */
	public void setMdUuid(String mdUuid) {
		this.mdUuid = mdUuid;
	}

	/**
	 * Gets the md date.
	 *
	 * @return the md date
	 */
	public Calendar getMdDate() {
		return mdDate;
	}

	/**
	 * Sets the md date.
	 *
	 * @param mdDate the new md date
	 */
	public void setMdDate(Calendar mdDate) {
		this.mdDate = mdDate;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the marca.
	 *
	 * @return the marca
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Sets the marca.
	 *
	 * @param marca the new marca
	 */
	public void setBrand(String marca) {
		this.brand = marca;
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
	 * Gets the type.
	 *
	 * @return the type
	 */
	public VehicleType getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(VehicleType type) {
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
	 * Gets the owner.
	 *
	 * @return the owner
	 */
	public User getOwner() {
		return owner;
	}

	/**
	 * Sets the owner.
	 *
	 * @param owner the new owner
	 */
	public void setOwner(User owner) {
		this.owner = owner;
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

	public Fuel getFuel() {
		return fuel;
	}

	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}

}
