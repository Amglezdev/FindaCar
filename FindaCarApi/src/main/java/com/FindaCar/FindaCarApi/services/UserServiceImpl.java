package com.FindaCar.FindaCarApi.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.FindaCar.FindaCarApi.entities.User;
import com.FindaCar.FindaCarApi.repositories.UserRepository;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Override
	public ArrayList<User> getAllUsers() {
		try {
			return (ArrayList<User>) userRepo.findAll();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean createUser(User user) {
		try {
			userRepo.save(user);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	@Override
	public User findByEmailAndPassword(String mail, String password) {
		try {
			return userRepo.findByMailAndPassword(mail, password);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public boolean deleteUser(Long id) {
		try {
			userRepo.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public boolean updateUser(User user) {
		try {
			userRepo.save(user);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

	@Override
	public User findById(long id) {
		
		try {
			return userRepo.findById(id).orElse(null);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@Override
	public boolean userExists(String mail, String password) {
		try {
			return userRepo.existsByMailAndPassword(mail, password);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
	}

}
