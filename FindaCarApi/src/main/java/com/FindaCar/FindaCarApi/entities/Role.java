package com.FindaCar.FindaCarApi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Role.
 */
@Entity
@Table(name = "fac_gu_roles", schema = "sc_findacar_gestion_usuarios")
public class Role {
	
	/** The name. */
	@Id
	@Column(name = "name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
}