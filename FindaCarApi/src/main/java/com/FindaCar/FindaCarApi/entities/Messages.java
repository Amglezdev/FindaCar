package com.FindaCar.FindaCarApi.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	/** The content. */
	@Column(name = "contenido")
	private String content;
	
	/** The conversation. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conversacion")
	private Conversation conversation;

	/**
	 * Gets the content.
	 *
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Gets the conversation.
	 *
	 * @return the conversation
	 */
	public Conversation getConversation() {
		return conversation;
	}

	/**
	 * Sets the conversation.
	 *
	 * @param conversation the new conversation
	 */
	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
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



	
}
