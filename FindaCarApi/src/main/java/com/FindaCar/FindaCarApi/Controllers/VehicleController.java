package com.FindaCar.FindaCarApi.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FindaCar.FindaCarApi.dto.VehicleDto;
import com.FindaCar.FindaCarApi.dto.converters.DtoToImpl;
import com.FindaCar.FindaCarApi.dto.converters.ToDtoImpl;
import com.FindaCar.FindaCarApi.services.VehicleServiceImpl;

@RestController
@RequestMapping("/vehicles")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080" })
public class VehicleController {

	@Autowired
	VehicleServiceImpl vehicleImpl;
	@Autowired
	ToDtoImpl toDto;
	@Autowired
	DtoToImpl dtoTo;

	@GetMapping("/findAll")
	public ArrayList<VehicleDto> getAllVehicles() {
		try {
			return toDto.listVehicleToDto(vehicleImpl.findAllVehicles());
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@GetMapping("/findById")
	public VehicleDto findById(@Param(value = "id") long id) {
		try {
			return toDto.vehicleToDto(vehicleImpl.findById(id));
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	@PutMapping("/addVehicle")
	public boolean addVehicle(@RequestBody VehicleDto dto) {
		try {
			return vehicleImpl.addVehicle(dtoTo.vehicleToDao(dto));
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@PostMapping("/updateVehicle")
	public boolean updateVehicle(@RequestBody VehicleDto dto) {
		try {
			return vehicleImpl.updateVehicle(dtoTo.vehicleToDao(dto));
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@GetMapping("/findByOwnerId")
	public ArrayList<VehicleDto> findByOwnerId(@Param(value = "id") long id) {
		try {
			return toDto.listVehicleToDto(vehicleImpl.findVehicleByOwnerId(id));
		} catch (Exception e) {
			// TODO: handle exception
			return null;	
		}
	}

}
