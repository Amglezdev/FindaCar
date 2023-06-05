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

	public UserDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleDto getRol() {
		return rol;
	}

	public void setRol(RoleDto rol) {
		this.rol = rol;
	}

}
