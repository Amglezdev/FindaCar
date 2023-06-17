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

import com.FindaCar.FindaCarApi.dto.ConversationDto;
import com.FindaCar.FindaCarApi.dto.converters.DtoToImpl;
import com.FindaCar.FindaCarApi.dto.converters.ToDtoImpl;
import com.FindaCar.FindaCarApi.services.ConversationServiceImpl;
import com.FindaCar.FindaCarApi.services.UserServiceImpl;
import com.FindaCar.FindaCarApi.util.Logger;

@RestController
@RequestMapping("/conversations")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080", "http://localhost:80" })
public class ConversationController {

	@Autowired
	ToDtoImpl toDto;
	@Autowired
	DtoToImpl dtoTo;
	@Autowired
	Logger log;
	@Autowired
	ConversationServiceImpl converService;
	@Autowired
	UserServiceImpl userService;

	@PutMapping("/createConversation")
	public boolean createConversation(@RequestBody ConversationDto conversation) {
		try {
			return converService.createConversation(dtoTo.converstaionToDao(conversation));
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@GetMapping("/getConversationForUser")
	public ArrayList<ConversationDto> conversationsForUser(@Param(value = "id") long id) {
		try {
			return toDto.listConversationToDto(converService.findConversationByUser(userService.findById(id)));
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@GetMapping("/findConversationByUserAndReciever")
	public ConversationDto conversationByUserAndReciever(@Param(value = "senderId") Long senderId, @Param(value = "recieverId") Long recieverId){
		try {
			return toDto.conversationToDto(converService.findConversationBySenderAndReciever(userService.findById(senderId), userService.findById(recieverId)));
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@GetMapping("/getById")
	public ConversationDto findById(@Param(value = "id") Long id) {
		try {
			return toDto.conversationToDto(converService.findById(id));
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
