package com.FindaCar.FindaCarApi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Fuel.
 */
@Entity
@Table(name = "fac_da_fuels", schema = "sc_findacar_datos_aplicacion")
public class Fuel {
	
	/** The name. */
	@Id
	@Column(name = "name")
	private String name;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
