package com.FindaCar.FindaCarApi.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FindaCar.FindaCarApi.dto.converters.DtoToImpl;
import com.FindaCar.FindaCarApi.dto.converters.ToDtoImpl;
import com.FindaCar.FindaCarApi.services.ConversationServiceImpl;

@RestController
@RequestMapping("/conversations")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080","http://localhost:80"  })
public class ConversationController {
	
	@Autowired
	ToDtoImpl toDto;
	@Autowired
	DtoToImpl dtoTo;
	@Autowired
	ConversationServiceImpl converService;
	
	

}
