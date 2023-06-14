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
import com.FindaCar.FindaCarApi.util.Logger;

@RestController
@RequestMapping("/vehicleType")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080" ,"http://localhost:80"})
public class VehicleTypeController {

	@Autowired
	VehicleTypeServiceImpl vts;
	@Autowired
	ToDtoImpl toDto;
	@Autowired
	DtoToImpl dtoTo;
	@Autowired
	Logger log;

	@GetMapping("/allTypes")
	public ArrayList<VehicleTypeDto> listAllTypes() {
		Logger.log("Entering endpoint /vehicleType/allTypes");
		try {
			Logger.log("Returing type list");
			return toDto.listVehicleTypeToDto(vts.findAllVehicleTypes());
		} catch (Exception e) {
			// TODO: handle exception
			Logger.log("Error in /vehicleType/allTypes");
			return null;
		}
	}

	@GetMapping("/getById")
	public VehicleTypeDto findById(@Param(value = "id") String id) {
		Logger.log("Entering endpoint /vehicleType/getById");
		try {
			Logger.log("Returing type with id:" + id);
			return toDto.vehicleTypeToDto(vts.findById(id));
		} catch (Exception e) {
			Logger.log("Error in /vehicleType/getById");
			return null;
			// TODO: handle exception
		}
	}
	
	@PutMapping("/addType")
	public boolean addType(@RequestBody VehicleTypeDto dto) {
		Logger.log("Entering endpoint /vehicleType/addType");
		try {
			Logger.log("Adding new type");
			return vts.addType(dtoTo.vehicleTypeToDao(dto));
		}catch (Exception e) {
			// TODO: handle exception
			Logger.log("Error in /vehicleType/addType");
			return false;
		}
	}
}
