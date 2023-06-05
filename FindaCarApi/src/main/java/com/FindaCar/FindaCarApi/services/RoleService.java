package com.FindaCar.FindaCarApi.services;

import java.util.ArrayList;

import com.FindaCar.FindaCarApi.entities.Role;

// TODO: Auto-generated Javadoc
/**
 * The Interface RoleService.
 */
public interface RoleService {
	
	/**
	 * Gets the role by id.
	 *
	 * @param id the id
	 * @return the role by id
	 */
	public Role getRoleById(String id);

	/**
	 * Gets the all roles.
	 *
	 * @return the all roles
	 */
	public ArrayList<Role> getAllRoles();
}
