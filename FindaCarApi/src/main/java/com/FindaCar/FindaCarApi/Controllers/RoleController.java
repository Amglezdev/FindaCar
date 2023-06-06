package com.FindaCar.FindaCarApi.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FindaCar.FindaCarApi.dto.RoleDto;
import com.FindaCar.FindaCarApi.dto.converters.DtoToImpl;
import com.FindaCar.FindaCarApi.dto.converters.ToDtoImpl;
import com.FindaCar.FindaCarApi.services.RoleServiceImpl;

@RestController
@RequestMapping("/roles")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080" })
public class RoleController {
	
	@Autowired
	RoleServiceImpl roleImpl;
	@Autowired
	ToDtoImpl toDto;
	@Autowired
	DtoToImpl dtoTo;

	@GetMapping("/getAllRoles")
	public ArrayList<RoleDto> findAllRoles() {
		try {					
			return toDto.listRoleToDto(roleImpl.getAllRoles());
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@GetMapping("/roleById")
	public RoleDto roleById(@Param(value = "roleId") String id) {
		try {
			return toDto.roleToDto(roleImpl.getRoleById(id));
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

}