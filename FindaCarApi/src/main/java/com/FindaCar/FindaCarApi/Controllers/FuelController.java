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

import com.FindaCar.FindaCarApi.dto.FuelDto;
import com.FindaCar.FindaCarApi.dto.converters.DtoToImpl;
import com.FindaCar.FindaCarApi.dto.converters.ToDtoImpl;
import com.FindaCar.FindaCarApi.services.FuelServiceImpl;
import com.FindaCar.FindaCarApi.util.Logger;

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080","http://localhost:80" })
@RequestMapping("/fuels")
public class FuelController {

	@Autowired
	ToDtoImpl toDto;
	@Autowired
	DtoToImpl dtoTo;
	@Autowired
	FuelServiceImpl fsi;
	@Autowired
	Logger log;

	@GetMapping("/getAll")
	public ArrayList<FuelDto> getAll() {
		Logger.log("Entering endpoint /fuels/getAll");
		try {
			Logger.log("Returning all fuels");
			return toDto.listFuelToDto(fsi.getAll());
		} catch (Exception e) {
			Logger.log("Error in /fuels/getAll");
			// TODO: handle exception
			return null;
		}
	}

	@GetMapping("/getById")
	public FuelDto getById(@Param(value = "id") String id) {
		Logger.log("Entering endpoint /fuels/getById");
		try {
			Logger.log("Returning fuel with id: " + id);
			return toDto.fuelToDto(fsi.findById(id));
		} catch (Exception e) {
			// TODO: handle exception
			Logger.log("Error in /fuels/getById");
			return null;
		}
	}

	@PutMapping("/addFuel")
	public boolean addFuel(@RequestBody FuelDto dto) {
		Logger.log("Entering endpoint /fuels/addFuel");
		try {
			Logger.log("Creating new fuel");
			return fsi.addFuel(dtoTo.fuelToDao(dto));
		} catch (Exception e) {
			// TODO: handle exception
			Logger.log("Error in /fuels/addFuel");
			return false;
		}

	}
}
