package com.FindaCar.FindaCarApi.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.FindaCar.FindaCarApi.entities.Messages;
import com.FindaCar.FindaCarApi.repositories.MessageRepository;

public class MessageServiceImpl implements MessageService {

	@Autowired
	MessageRepository mRepo;

	@Override
	public ArrayList<Messages> findBySenderAndReciever(long senderId, long recieverId) {
		try {
			return (ArrayList<Messages>) mRepo.findBySenderIdAndRecieverId(senderId, recieverId);
		} catch (Exception e) {
			// TODO: handle exception4
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

}
