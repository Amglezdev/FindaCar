package com.FindaCar.FindaCarApi.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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

@RestController
@RequestMapping("/pictures")
public class VehiclePicturesController {

	@Autowired
	VehiclePicturesServiceImpl vps;
	@Autowired
	ToDtoImpl toDto;
	@Autowired
	DtoToImpl dtoTo;

	@GetMapping("/findAllById")
	public ArrayList<VehiclePicturesDto> findByCarId(@Param(value = "id") long id) {
		try {
			return toDto.listVehiclePicturesToDto(vps.findByVehicleId(id));
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@PutMapping("/addPicture")
	public boolean addPicture(@RequestBody VehiclePicturesDto dto) {
		try {
			return vps.addPicture(dtoTo.vehiclePicturesToDao(dto));
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

	}

	@DeleteMapping("/deletePicture")
	public boolean deletePicture(@Param(value = "id") long id) {
		try {
			return vps.deletePictureById(id);
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
