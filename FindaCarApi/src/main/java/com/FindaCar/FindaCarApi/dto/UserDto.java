package com.FindaCar.FindaCarApi.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDto.
 */
public class UserDto {

	/** The id. */
	private Long id;

	/** The name. */
	private String name;

	/** The surname. */
	private String surname;

	/** The phone number. */
	private String phoneNumber;

	/** The mail. */
	private String mail;

	/** The password. */
	private String password;

	/** The rol id. */
	private RoleDto rol;

	/** The security. */
	private String security;

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
	 * Instantiates a new user dto.
	 */
	public UserDto() {
		super();
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
	 * Gets the rol.
	 *
	 * @return the rol
	 */
	public RoleDto getRol() {
		return rol;
	}

	/**
	 * Sets the rol.
	 *
	 * @param rol the new rol
	 */
	public void setRol(RoleDto rol) {
		this.rol = rol;
	}

}
