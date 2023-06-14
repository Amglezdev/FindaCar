package com.FindaCar.FindaCarApi.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FindaCar.FindaCarApi.dto.VehiclePicturesDto;
import com.FindaCar.FindaCarApi.dto.converters.DtoToImpl;
import com.FindaCar.FindaCarApi.dto.converters.ToDtoImpl;
import com.FindaCar.FindaCarApi.services.VehiclePicturesServiceImpl;
import com.FindaCar.FindaCarApi.util.Logger;

@RestController
@RequestMapping("/pictures")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080","http://localhost:80" })
public class VehiclePicturesController {

	@Autowired
	VehiclePicturesServiceImpl vps;
	@Autowired
	ToDtoImpl toDto;
	@Autowired
	DtoToImpl dtoTo;
	@Autowired
	Logger log;

	@GetMapping("/findAllById")
	public ArrayList<VehiclePicturesDto> findByCarId(@Param(value = "id") long id) {
		Logger.log("Entering endpoint /pictures/findAllById");
		try {
			Logger.log("Returning pictures for vehicle id:" + id);
			return toDto.listVehiclePicturesToDto(vps.findByVehicleId(id));
		} catch (Exception e) {
			// TODO: handle exception
			Logger.log("Error in /pictures/findAllById");
			return null;
		}
	}

	@PutMapping("/addPicture")
	public boolean addPicture(@RequestBody VehiclePicturesDto dto) {
		Logger.log("Entering endpoint /pictures/addPicture");
		try {
			Logger.log("Adding new picture");
			return vps.addPicture(dtoTo.vehiclePicturesToDao(dto));
		} catch (Exception e) {
			// TODO: handle exception
			Logger.log("Error in /pictures/addPicture");
			return false;
		}

	}

	@DeleteMapping("/deletePicture")
	public boolean deletePicture(@Param(value = "id") long id) {
		Logger.log("Entering endpoint /pictures/deletePicture");
		try {
			Logger.log("Deleting picture with id:" + id);
			return vps.deletePictureById(id);
		} catch (Exception e) {
			// TODO: handle exception
			Logger.log("Error in /pictures/deletePicture");
			return false;
		}
	}

}
