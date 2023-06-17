package com.FindaCar.FindaCarApi.entities;

import java.util.Calendar;
import java.util.List;

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
 * The Class Conversation.
 */
@Entity
@Table(name = "fac_da_conversaciones", schema = "sc_findacar_datos_aplicacion")
public class Conversation {

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

	/** The sender. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "remitente")
	private User sender;

	/** The reciever. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "destinatario")
	private User reciever;
	
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "conversation")
//	@JsonIgnore
//	private List<Messages> messages;

	
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
	 * Gets the sender.
	 *
	 * @return the sender
	 */
	public User getSender() {
		return sender;
	}

	/**
	 * Sets the sender.
	 *
	 * @param sender the new sender
	 */
	public void setSender(User sender) {
		this.sender = sender;
	}

	/**
	 * Gets the reciever.
	 *
	 * @return the reciever
	 */
	public User getReciever() {
		return reciever;
	}

	/**
	 * Sets the reciever.
	 *
	 * @param reciever the new reciever
	 */
	public void setReciever(User reciever) {
		this.reciever = reciever;
	}
	
 }
