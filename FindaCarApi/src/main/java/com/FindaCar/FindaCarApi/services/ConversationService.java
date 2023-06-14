package com.FindaCar.FindaCarApi.services;

import java.util.ArrayList;

import com.FindaCar.FindaCarApi.entities.Conversation;
import com.FindaCar.FindaCarApi.entities.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface ConversationService.
 */
public interface ConversationService {
	
	/**
	 * Creates the conversation.
	 *
	 * @param dao the dao
	 * @return true, if successful
	 */
	public boolean createConversation(Conversation dao);
	
	/**
	 * Find conversation by user.
	 *
	 * @param sender the sender
	 * @return the array list
	 */
	public ArrayList<Conversation> findConversationByUser(User sender);
	
	/**
	 * Find conversation by sender and reciever.
	 *
	 * @param sender the sender
	 * @param reciever the reciever
	 * @return the conversation
	 */
	public Conversation findConversationBySenderAndReciever(User sender, User reciever);
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the conversation
	 */
	public Conversation findById(long id);
	

}
