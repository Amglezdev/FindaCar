package com.FindaCar.FindaCarApi.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FindaCar.FindaCarApi.entities.Conversation;
import com.FindaCar.FindaCarApi.entities.User;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long>{
	
	public Conversation findBySenderAndRecieverOrRecieverAndSender(User sender1, User reciever1, User reciever2, User sender2);
	
	public ArrayList<Conversation> findBySenderOrReciever(User user1, User user2);
	
}
