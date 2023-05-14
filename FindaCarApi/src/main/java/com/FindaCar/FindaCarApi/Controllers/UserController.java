package com.FindaCar.FindaCarApi.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FindaCar.FindaCarApi.entities.User;
import com.FindaCar.FindaCarApi.services.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserServiceImpl userImpl;

	@GetMapping("/allUsers")
	public ArrayList<User> getUsers() {
		try {
			return userImpl.getAllUsers();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@PutMapping("/addUser")
	public boolean addUser(User user) {
		try {
			return userImpl.createUser(user);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@GetMapping("/getByMailAndPassword")
	public User getUserByMailAndPassword(@Param(value = "mail") String mail,
			@Param(value = "password") String password) {
		try {
			return userImpl.findByEmailAndPassword(mail, password);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}
