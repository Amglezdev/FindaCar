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

import com.fasterxml.jackson.annotation.JsonIgnore;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
@Entity
@Table(name = "fac_gu_usuarios", schema = "sc_findacar_gestion_usuarios")
public class User {

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

	/** The name. */
	@Column(name = "nombre")
	private String name;

	/** The surname. */
	@Column(name = "apellidos")
	private String surname;

	/** The phone number. */
	@Column(name = "telefono")
	private String phoneNumber;

	/** The mail. */
	@Column(name = "correo_electronico")
	private String mail;

	/** The password. */
	@Column(name = "clave_usuario")
	private String password;

	/** The role. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rol_usuario")
	private Role role;

	/** The vehicles owned. */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
	@JsonIgnore
	private List<Vehicle> vehiclesOwned;

	/** The security. */
	@Column(name = "pregunta_seguridad")
	private String security;

	/** The messages sent. */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sender", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Messages> messagesSent;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "reciever", cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Messages> messagesReceived;

	/**
	 * Gets the security.
	 *
	 * @return the security
	 */
	public String getSecurity() {
		return security;
	}

	/**
	 * Sets the security.
	 *
	 * @param security the new security
	 */
	public void setSecurity(String security) {
		this.security = security;
	}

	/**
	 * Gets the vehicles owned.
	 *
	 * @return the vehicles owned
	 */
	public List<Vehicle> getVehiclesOwned() {
		return vehiclesOwned;
	}

	/**
	 * Sets the vehicles owned.
	 *
	 * @param vehiclesOwned the new vehicles owned
	 */
	public void setVehiclesOwned(List<Vehicle> vehiclesOwned) {
		this.vehiclesOwned = vehiclesOwned;
	}

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

	/**
	 * Gets the surname.
	 *
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Sets the surname.
	 *
	 * @param surname the new surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber the new phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets the mail.
	 *
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * Sets the mail.
	 *
	 * @param mail the new mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the role.
	 *
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Sets the role.
	 *
	 * @param role the new role
	 */
	public void setRole(Role role) {
		this.role = role;
	}

}
