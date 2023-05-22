package com.FindaCar.FindaCarApi.dto.converters;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.FindaCar.FindaCarApi.dto.UserDto;
import com.FindaCar.FindaCarApi.dto.converters.service.ToDtoService;
import com.FindaCar.FindaCarApi.entities.User;

@Component
public class ToDtoImpl implements ToDtoService {

	@Override
	public UserDto userToDto(User user) {
		UserDto dto = new UserDto();

		dto.setId(user.getId());
		dto.setMail(user.getMail());
		dto.setName(user.getName());
		dto.setPassword(user.getPassword());
		dto.setPhoneNumber(user.getPhoneNumber());
		dto.setRolId(user.getRole().getId());

		return dto;
	}

	@Override
	public ArrayList<UserDto> listUserToDto(ArrayList<User> listDto) {

		ArrayList<UserDto> listUser = new ArrayList<>();

		for (User user : listDto) {
			listUser.add(userToDto(user));
		}

		return listUser;
	}

}
