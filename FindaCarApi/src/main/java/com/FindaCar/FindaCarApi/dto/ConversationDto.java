package com.FindaCar.FindaCarApi.dto;

// TODO: Auto-generated Javadoc
/**
 * The Class ConversationDto.
 */
public class ConversationDto {
	
	/** The id. */
	private long id;
	
	/** The sender. */
	private UserDto sender;
	
	/** The reciever. */
	private UserDto reciever;
	
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
	public UserDto getSender() {
		return sender;
	}
	
	/**
	 * Sets the sender.
	 *
	 * @param sender the new sender
	 */
	public void setSender(UserDto sender) {
		this.sender = sender;
	}
	
	/**
	 * Gets the reciever.
	 *
	 * @return the reciever
	 */
	public UserDto getReciever() {
		return reciever;
	}
	
	/**
	 * Sets the reciever.
	 *
	 * @param reciever the new reciever
	 */
	public void setReciever(UserDto reciever) {
		this.reciever = reciever;
	}
	
	
	


}
