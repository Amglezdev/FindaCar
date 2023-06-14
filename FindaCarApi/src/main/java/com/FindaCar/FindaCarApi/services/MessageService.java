package com.FindaCar.FindaCarApi.services;

import java.util.ArrayList;

import com.FindaCar.FindaCarApi.entities.Conversation;
import com.FindaCar.FindaCarApi.entities.Messages;

// TODO: Auto-generated Javadoc
/**
 * The Interface MessageService.
 */
public interface MessageService {	
	/**
	 * Send message.
	 *
	 * @param message the message
	 * @return true, if successful
	 */
	public boolean sendMessage(Messages message);
	
	/**
	 * Find by conversation.
	 *
	 * @param conversation the conversation
	 * @return the array list
	 */
	public ArrayList<Messages> findByConversation(Conversation conversation);
		
}
