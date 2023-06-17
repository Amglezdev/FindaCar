package com.FindaCar.FindaCarApi.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.FindaCar.FindaCarApi.entities.Conversation;
import com.FindaCar.FindaCarApi.entities.User;
import com.FindaCar.FindaCarApi.repositories.ConversationRepository;

@Component
public class ConversationServiceImpl implements ConversationService {

	@Autowired
	ConversationRepository converRepo;

	@Override
	public boolean createConversation(Conversation dao) {
		try {
			converRepo.save(dao);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public ArrayList<Conversation> findConversationByUser(User user) {
		try {
			return (ArrayList<Conversation>) converRepo.findBySenderOrReciever(user, user);
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public Conversation findConversationBySenderAndReciever(User sender, User reciever) {
		try {
			return converRepo.findBySenderAndRecieverOrRecieverAndSender(sender, reciever, sender, reciever);
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public Conversation findById(long id) {
		try {
			return converRepo.findById(id).orElse(null);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
