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

import com.FindaCar.FindaCarApi.dto.UserFavoritesDto;
import com.FindaCar.FindaCarApi.dto.converters.DtoToImpl;
import com.FindaCar.FindaCarApi.dto.converters.ToDtoImpl;
import com.FindaCar.FindaCarApi.services.UserFavoritesServiceImpl;
import com.FindaCar.FindaCarApi.util.Logger;

@RestController
@RequestMapping("/userFavorites")
@CrossOrigin(origins = { "http://localhost:4200", "http://localhost:8080" ,"http://localhost:80"})
public class UserFavoritesController {

	@Autowired
	UserFavoritesServiceImpl ufService;
	@Autowired
	ToDtoImpl toDto;
	@Autowired
	DtoToImpl dtoTo;
	@Autowired
	Logger log;

	@GetMapping("/getByUserId")
	public ArrayList<UserFavoritesDto> findByUserId(@Param(value = "id") long id) {
		Logger.log("Entering endpoint /userFavorites/getByUserId");
		try {
			Logger.log("Returning user favorite list");
			return toDto.listUserFavoritesToDto(ufService.findByUserId(id));
		} catch (Exception e) {
			// TODO: handle exception
			Logger.log("Error in /userFavorites/getByUserId");
			return null;
		}
	}

	@PutMapping("/addFavorites")
	public boolean addFavorites(@RequestBody UserFavoritesDto dto) {
		Logger.log("Entering endpoint /userFavorites/addFavorites");
		try {
			Logger.log("Adding to user favorite list");
			return ufService.addFavorite(dtoTo.userFavoritesToDao(dto));
		} catch (Exception e) {
			// TODO: handle exception
			Logger.log("Error in /userFavorites/addFavorites");
			return false;
		}
	}

	@DeleteMapping("/deleteFromFavorites")
	public boolean deleteFromFavorites(@RequestBody UserFavoritesDto dto) {
		Logger.log("Entering endpoint /userFavorites/deleteFromFavorites");
		try {
			Logger.log("Deleting from user favorite list");
			return ufService.removeFromFavorites(dtoTo.userFavoritesToDao(dto));
		} catch (Exception e) {
			// TODO: handle exception
			Logger.log("Error in /userFavorites/deleteFromFavorites");
			return false;
		}
	}

}
