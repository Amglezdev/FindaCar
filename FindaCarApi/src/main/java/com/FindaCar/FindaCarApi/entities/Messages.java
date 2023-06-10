package com.FindaCar.FindaCarApi.entities;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Messages.
 */
@Entity
@Table(name = "fac_da_mensajes", schema = "sc_findacar_datos_aplicacion")
public class Messages {

	/** The md uuid. */
	@Column(name = "md_uuid")
	private String mdUuid;

	/** The md date. */
	@Column(name = "md_date")
	private Calendar mdDate;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	/** The sender. */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "remitente")
	private User sender;

	/** The reciever. */
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "destinatario")
	private User reciever;

	/** The content. */
	@Column(name = "contenido")
	private String content;

	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return "Messages [mdUuid=" + mdUuid + ", mdDate=" + mdDate + ", id=" + id + ", sender=" + sender + ", reciever="
				+ reciever + ", content=" + content + "]";
	}

	/**
	 * Sets the content.
	 *
	 * @param content the new content
	 */
	public void setContent(String content) {
		this.content = content;
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
