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

@RestController
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080" })
@RequestMapping("/fuels")
public class FuelController {

	@Autowired
	ToDtoImpl toDto;
	@Autowired
	DtoToImpl dtoTo;
	@Autowired
	FuelServiceImpl fsi;

	@GetMapping("/getAll")
	public ArrayList<FuelDto> getAll() {
		try {
			return toDto.listFuelToDto(fsi.getAll());
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@GetMapping("/getById")
	public FuelDto getById(@Param(value = "id") String id) {
		try {
			return toDto.fuelToDto(fsi.findById(id));
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@PutMapping("/addFuel")
	public boolean addFuel(@RequestBody FuelDto dto) {
		try {
			return fsi.addFuel(dtoTo.fuelToDao(dto));
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}
}
