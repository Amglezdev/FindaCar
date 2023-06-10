package com.FindaCar.FindaCarApi.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FindaCar.FindaCarApi.dto.MessagesDto;
import com.FindaCar.FindaCarApi.dto.converters.DtoToImpl;
import com.FindaCar.FindaCarApi.dto.converters.ToDtoImpl;
import com.FindaCar.FindaCarApi.services.MessageServiceImpl;
import com.FindaCar.FindaCarApi.util.Logger;

@RestController
@RequestMapping("/messages")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080" })
public class MessageController {

	@Autowired
	MessageServiceImpl msi;
	@Autowired
	ToDtoImpl toDto;
	@Autowired
	DtoToImpl dtoTo;
	@Autowired
	Logger log;

	@GetMapping("/findMessages")
	public ArrayList<MessagesDto> findBySenderAndReciever(@Param(value = "senderId") Long senderId,
			@Param(value = "recieverId") Long recieverId) {
		Logger.log("Entering endpoint /messages/findMessages");
		try {
			Logger.log("Returning messages");
			return toDto.listMessagesToDto(msi.findBySenderIdAndRecieverIdOrSenderIdAndRecieverId(senderId, recieverId));
		} catch (Exception e) {
			// TODO: handle exception
			Logger.log("Error in /messages/findMessages");
			return null;
		}
	}

	@PutMapping("/sendMessage")
	public boolean sendMessage(@RequestBody MessagesDto message) {
		Logger.log("Entering endpoint /messages/sendMessage");
		try {
			Logger.log("Creating message");
			return msi.sendMessage(dtoTo.messageToDao(message));
		} catch (Exception e) {
			// TODO: handle exception
			Logger.log("Error in /messages/sendMessage");
			return false;
		}
	}
	
	@GetMapping("/findBySenderId")
	public ArrayList<MessagesDto> findBySender(@Param(value = "senderId") long senderId) {
		Logger.log("Entering endpoint /messages/findBySenderId");
		try {
			Logger.log("Returning messages");
			return toDto.listMessagesToDto(msi.findByUser(senderId));
		} catch (Exception e) {
			// TODO: handle exception
			Logger.log("Error in /messages/findBySenderId");
			return null;
		}
	}

}
