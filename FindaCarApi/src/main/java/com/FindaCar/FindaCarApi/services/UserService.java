package com.FindaCar.FindaCarApi.services;

import java.util.ArrayList;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import com.FindaCar.FindaCarApi.entities.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserService.
 */
public interface UserService {

	/**
	 * Gets all the users.
	 *
	 * @return the all users
	 */
	public ArrayList<User> getAllUsers();
	
	public boolean createUser(@RequestBody User user);
	
	public User findByEmailAndPassword(String mail, String password);

}
