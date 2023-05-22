package com.FindaCar.FindaCarApi.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.FindaCar.FindaCarApi.entities.Role;
import com.FindaCar.FindaCarApi.repositories.RoleRepository;

@Component
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepo;

	@Override
	public Role getRoleById(Integer id) {
		try {
			return roleRepo.findById(id).orElse(null);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public ArrayList<Role> getAllRoles() {
		try {
			return (ArrayList<Role>) roleRepo.findAll();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

}
