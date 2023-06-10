package com.FindaCar.FindaCarApi.services;

import java.util.ArrayList;

import com.FindaCar.FindaCarApi.entities.Messages;

// TODO: Auto-generated Javadoc
/**
 * The Interface MessageService.
 */
public interface MessageService {

	/**
	 * Find by sender and reciever.
	 *
	 * @param senderId the sender id
	 * @param recieverId the reciever id
	 * @return the array list
	 */
	public ArrayList<Messages> findBySenderIdAndRecieverIdOrSenderIdAndRecieverId(Long senderId, Long recieverId);
	
	/**
	 * Send message.
	 *
	 * @param message the message
	 * @return true, if successful
	 */
	public boolean sendMessage(Messages message);
	
	/**
	 * Find by user.
	 *
	 * @return the array list
	 */
	public ArrayList<Messages> findByUser(long id);

}
