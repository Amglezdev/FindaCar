package com.FindaCar.FindaCarApi.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.FindaCar.FindaCarApi.dto.VehicleTypeDto;
import com.FindaCar.FindaCarApi.dto.converters.DtoToImpl;
import com.FindaCar.FindaCarApi.dto.converters.ToDtoImpl;
import com.FindaCar.FindaCarApi.services.VehicleTypeServiceImpl;

@Controller
@RequestMapping("/vehicleType")
public class VehicleTypeController {

	@Autowired
	VehicleTypeServiceImpl vts;
	@Autowired
	ToDtoImpl toDto;
	@Autowired
	DtoToImpl dtoTo;

	@GetMapping("/allTypes")
	public ArrayList<VehicleTypeDto> listAllTypes() {
		try {
			return toDto.listVehicleTypeToDto(vts.findAllVehicleTypes());
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@GetMapping("/getById")
	public VehicleTypeDto findById(@Param(value = "id") long id) {
		try {
			return toDto.vehicleTypeToDto(vts.findById(id));
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
	}
}
