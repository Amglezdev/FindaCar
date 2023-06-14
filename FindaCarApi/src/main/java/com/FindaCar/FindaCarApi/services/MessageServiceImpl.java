package com.FindaCar.FindaCarApi.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.FindaCar.FindaCarApi.entities.Conversation;
import com.FindaCar.FindaCarApi.entities.Messages;
import com.FindaCar.FindaCarApi.repositories.MessageRepository;

@Component
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageRepository mRepo;



	@Override
	public boolean sendMessage(Messages message) {
		try {
			mRepo.save(message);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}



	@Override
	public ArrayList<Messages> findByConversation(Conversation conversation) {
		try {
			return (ArrayList<Messages>)mRepo.findByConversation(conversation);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}





	

}
