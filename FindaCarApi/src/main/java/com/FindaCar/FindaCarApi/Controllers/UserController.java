package com.FindaCar.FindaCarApi.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FindaCar.FindaCarApi.dto.UserDto;
import com.FindaCar.FindaCarApi.dto.converters.DtoToImpl;
import com.FindaCar.FindaCarApi.dto.converters.ToDtoImpl;
import com.FindaCar.FindaCarApi.services.UserServiceImpl;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080" })
public class UserController {

	@Autowired
	UserServiceImpl userImpl;
	@Autowired
	ToDtoImpl toDto;
	@Autowired
	DtoToImpl dtoTo;

	@GetMapping("/getById")
	public UserDto getById(@Param(value = "id") Long id) {
		try {
			return toDto.userToDto(userImpl.findById(id));
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	@GetMapping("/getUsers")
	public ArrayList<UserDto> getUsers() {
		try {
			return toDto.listUserToDto(userImpl.getAllUsers());
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@PutMapping("/addUser")
	public boolean addUser(@RequestBody UserDto user) {
		try {
			if (userImpl.userExistsByMailAndPassword(user.getMail(), user.getPassword())) {
				return false;
			} else {
				return userImpl.createUser(dtoTo.userToDao(user));
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@PostMapping("/getByMailAndPassword")
	public UserDto getUserByMailAndPassword(@RequestBody UserDto user) {
		try {
			return toDto.userToDto(userImpl.findByEmailAndPassword(user.getMail(), user.getPassword()));
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@PostMapping("/updateUser")
	public boolean updateUser(@RequestBody UserDto user) {
		try {
			return userImpl.updateUser(dtoTo.userToDao(user));
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@DeleteMapping("/deleteUser")
	public boolean deleteUser(@Param(value = "id") Long id) {
		try {
			return userImpl.deleteUser(id);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	@PostMapping("/userExists")		
	public boolean userExists(@RequestBody UserDto user) {
		try {
			return userImpl.userExistsByMail(user.getMail());
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
