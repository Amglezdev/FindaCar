package com.FindaCar.FindaCarApi.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FindaCar.FindaCarApi.dto.VehicleTypeDto;
import com.FindaCar.FindaCarApi.dto.converters.DtoToImpl;
import com.FindaCar.FindaCarApi.dto.converters.ToDtoImpl;
import com.FindaCar.FindaCarApi.services.VehicleTypeServiceImpl;

@RestController
@RequestMapping("/vehicleType")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080" })
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
	public VehicleTypeDto findById(@Param(value = "id") String id) {
		try {
			return toDto.vehicleTypeToDto(vts.findById(id));
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
	}
	
	@PutMapping("/addType")
	public boolean addType(@RequestBody VehicleTypeDto dto) {
		try {
			return vts.addType(dtoTo.vehicleTypeToDao(dto));
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
