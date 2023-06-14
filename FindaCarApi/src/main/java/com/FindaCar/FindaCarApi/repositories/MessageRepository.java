package com.FindaCar.FindaCarApi.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FindaCar.FindaCarApi.entities.Conversation;
import com.FindaCar.FindaCarApi.entities.Messages;

// TODO: Auto-generated Javadoc
/**
 * The Interface MessageRepository.
 */
@Repository
public interface MessageRepository extends JpaRepository<Messages, Long> {

	/**
	 * Find by conversation.
	 *
	 * @param conver the conver
	 * @return the array list
	 */
	public ArrayList<Messages> findByConversation(Conversation conver);

}


