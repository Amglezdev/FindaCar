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
import com.FindaCar.FindaCarApi.util.Logger;
import com.FindaCar.FindaCarApi.util.PasswordEncryptor;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080","http://localhost:80" })
public class UserController {

	@Autowired
	UserServiceImpl userImpl;
	@Autowired
	ToDtoImpl toDto;
	@Autowired
	DtoToImpl dtoTo;
	@Autowired
	PasswordEncryptor pe;
	@Autowired
	Logger log;

	@GetMapping("/getById")
	public UserDto getById(@Param(value = "id") Long id) {
		Logger.log("Entering endpoint /users/getById");
		try {
			Logger.log("Returning user with id:" + id);
			return toDto.userToDto(userImpl.findById(id));
		} catch (Exception e) {
			Logger.log("Error in /users/getById");
			// TODO: handle exception
			return null;
		}

	}

	@GetMapping("/getUsers")
	public ArrayList<UserDto> getUsers() {
		Logger.log("Entering endpoint /users/getUsers");
		try {
			Logger.log("Returning all users");
			return toDto.listUserToDto(userImpl.getAllUsers());
		} catch (Exception e) {
			// TODO: handle exception
			Logger.log("Error in /users/getUsers");
			return null;
		}
	}

	@PutMapping("/addUser")
	public boolean addUser(@RequestBody UserDto user) {
		Logger.log("Entering endpoint /users/addUser");
		try {
			if (userImpl.userExistsByMailAndPassword(user.getMail(), pe.encryptPassword(user.getPassword()))) {
				Logger.log("User already exists");
				return false;
			} else {
				Logger.log("Hashing password");
				user.setPassword(pe.encryptPassword(user.getPassword()));
				Logger.log("Creating new user");
				return userImpl.createUser(dtoTo.userToDao(user));
			}
		} catch (Exception e) {
			// TODO: handle exception
			Logger.log("Error in /users/addUser");
			return false;
		}
	}

	@PostMapping("/getByMailAndPassword")
	public UserDto getUserByMailAndPassword(@RequestBody UserDto user) {
		Logger.log("Entering endpoint /users/addUser");
		try {
			Logger.log("Returning user by mail and password");
			return toDto
					.userToDto(userImpl.findByEmailAndPassword(user.getMail(), pe.encryptPassword(user.getPassword())));
		} catch (Exception e) {
			// TODO: handle exception
			Logger.log("Error in /users/getByMailAndPassword");
			return null;
		}
	}

	@PostMapping("/updateUser")
	public boolean updateUser(@RequestBody UserDto user) {
		Logger.log("Entering endpoint /users/updateUser");
		try {
			Logger.log("Updating user");
			return userImpl.updateUser(dtoTo.userToDao(user));
		} catch (Exception e) {
			// TODO: handle exception
			Logger.log("Error in /users/updateUser");
			return false;
		}
	}

	@DeleteMapping("/deleteUser")
	public boolean deleteUser(@Param(value = "id") Long id) {
		Logger.log("Entering endpoint /users/deleteUser");
		try {
			Logger.log("Deleting user with id:" + id);
			return userImpl.deleteUser(id);
		} catch (Exception e) {
			// TODO: handle exception
			Logger.log("Error in /users/deleteUser");
			return false;
		}
	}

	@PostMapping("/changePassword")
	public UserDto changePassword(@RequestBody UserDto user) {
		Logger.log("Entering endpoint /users/changePassword");
		try {
			if (userImpl.userExistsByMailAndSecurity(user.getMail(), user.getSecurity())) {
				String password = user.getPassword();
				String mail = user.getMail();
				user = toDto.userToDto(userImpl.findUserByMail(mail));
				user.setPassword(pe.encryptPassword(password));
				userImpl.updateUser(dtoTo.userToDao(user));
				Logger.log("Succesfully changed password");
				return user;
			}
			Logger.log("No user found");
			return null;
		} catch (Exception e) {
			// TODO: handle exception
			Logger.log("Error in /users/changePassword");
			return null;
		}
	}

}
