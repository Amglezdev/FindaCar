package com.FindaCar.FindaCarApi.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.FindaCar.FindaCarApi.dto.MessagesDto;
import com.FindaCar.FindaCarApi.dto.converters.DtoToImpl;
import com.FindaCar.FindaCarApi.dto.converters.ToDtoImpl;
import com.FindaCar.FindaCarApi.services.MessageServiceImpl;

@Controller
@RequestMapping("/messages")
public class MessageController {

	@Autowired
	MessageServiceImpl msi;
	@Autowired
	ToDtoImpl toDto;
	@Autowired
	DtoToImpl dtoTo;

	@GetMapping("/findMessages")
	public ArrayList<MessagesDto> findBySenderAndReciever(@Param(value = "senderId") long senderId,
			@Param(value = "recieverId") long recieverId) {
		try {
			return toDto.listMessagesToDto(msi.findBySenderAndReciever(senderId, recieverId));
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@PutMapping("/sendMessage")
	public boolean sendMessage(@RequestBody MessagesDto message) {
		try {
			return msi.sendMessage(dtoTo.messageToDao(message));
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
