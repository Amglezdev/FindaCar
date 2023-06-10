package com.FindaCar.FindaCarApi.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.FindaCar.FindaCarApi.entities.Messages;
import com.FindaCar.FindaCarApi.repositories.MessageRepository;

@Component
@RequestMapping("/message")
public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageRepository mRepo;

	@Override
	public ArrayList<Messages> findBySenderIdAndRecieverIdOrSenderIdAndRecieverId(Long senderId, Long recieverId) {
		try {
			return (ArrayList<Messages>) mRepo.findBySenderIdAndRecieverIdOrSenderIdAndRecieverId(senderId, recieverId, recieverId, senderId);
		} catch (Exception e) {
			// TODO: handle exception4
			System.out.println(e.getMessage());
			return null;
		}
	}

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
	public ArrayList<Messages> findByUser(long id) {
		try {
			return (ArrayList<Messages>) mRepo.findBySenderId(id);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
