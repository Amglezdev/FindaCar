package com.FindaCar.FindaCarApi.dto.converters;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.FindaCar.FindaCarApi.dto.PostDto;
import com.FindaCar.FindaCarApi.dto.UserDto;
import com.FindaCar.FindaCarApi.dto.converters.service.DtoToService;
import com.FindaCar.FindaCarApi.entities.Post;
import com.FindaCar.FindaCarApi.entities.User;
import com.FindaCar.FindaCarApi.services.RoleServiceImpl;

@Component
public class DtoToImpl implements DtoToService{
	
	private String mdUuid = UUID.randomUUID().toString();
	private Calendar calendar = Calendar.getInstance();
	
	@Autowired
	RoleServiceImpl roleService;
	

	@Override
	public User userToDao(UserDto dto) {
		
		User dao = new User();
		
		dao.setId(dto.getId());
		dao.setMail(dto.getMail());
		dao.setMdDate(calendar);
		dao.setMdUuid(mdUuid);
		dao.setName(dto.getName());
		dao.setPassword(dto.getPassword());
		dao.setPhoneNumber(dao.getPhoneNumber());
		dao.setRole(roleService.getRoleById(dto.getRolId()));
		dao.setSurname(dto.getSurname());
			
		return dao;
	}

	@Override
	public ArrayList<User> listUserToDao(ArrayList<UserDto> listDto) {	
		try {
			ArrayList<User> listUser = new ArrayList<>();
			
			for (UserDto user : listDto) {
				listUser.add(userToDao(user));
			}
			return listUser;
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public Post postToDao(PostDto dto) {
		Post dao = new Post();
		
		dao.setComment(dto.getComment());
		dao.setId(dto.getId());
		dao.setMdDate(calendar);
		dao.setMdUuid(mdUuid);
		dao.setVehicle(null);
		
		
		return null;
	}

	@Override
	public ArrayList<Post> listPostToDto(ArrayList<PostDto> listDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
