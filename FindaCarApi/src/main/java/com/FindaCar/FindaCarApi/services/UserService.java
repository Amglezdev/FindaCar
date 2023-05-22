package com.FindaCar.FindaCarApi.services;

import java.util.ArrayList;

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
	
	/**
	 * Creates the user.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	public boolean createUser(@RequestBody User user);
	
	/**
	 * Find by email and password.
	 *
	 * @param mail the mail
	 * @param password the password
	 * @return the user
	 */
	public User findByEmailAndPassword(String mail, String password);
	
	/**
	 * Delete user.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean deleteUser(Long id);
	
	/**
	 * Update user.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	public boolean updateUser(@RequestBody User user);
	
	

}
