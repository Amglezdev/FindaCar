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
import com.FindaCar.FindaCarApi.services.ConversationServiceImpl;
import com.FindaCar.FindaCarApi.services.MessageServiceImpl;
import com.FindaCar.FindaCarApi.util.Logger;

@RestController
@RequestMapping("/messages")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080", "http://localhost:80" })
public class MessageController {

	@Autowired
	MessageServiceImpl msi;
	@Autowired
	ToDtoImpl toDto;
	@Autowired
	DtoToImpl dtoTo;
	@Autowired
	Logger log;
	@Autowired
	ConversationServiceImpl converService;

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
	
	@GetMapping("/getMessages")
	public ArrayList<MessagesDto> findMessagesByConversation(@Param (value = "id")long id){
		try {			
			return toDto.listMessagesToDto(msi.findByConversation(converService.findById(id)));
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	

}
