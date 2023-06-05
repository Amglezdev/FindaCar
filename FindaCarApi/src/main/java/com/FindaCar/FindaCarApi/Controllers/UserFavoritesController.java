package com.FindaCar.FindaCarApi.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
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

@RestController
@RequestMapping("/userFavorites")
public class UserFavoritesController {

	@Autowired
	UserFavoritesServiceImpl ufService;
	@Autowired
	ToDtoImpl toDto;
	@Autowired
	DtoToImpl dtoTo;

	@GetMapping("/getByUserId")
	public ArrayList<UserFavoritesDto> findByUserId(@Param(value = "id") long id) {
		try {
			return toDto.listUserFavoritesToDto(ufService.findByUserId(id));
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@PutMapping("/addFavorites")
	public boolean addFavorites(@RequestBody UserFavoritesDto dto) {
		try {
			return ufService.addFavorite(dtoTo.userFavoritesToDao(dto));
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@DeleteMapping("/deleteFromFavorites")
	public boolean deleteFromFavorites(@RequestBody UserFavoritesDto dto) {
		try {
			return ufService.removeFromFavorites(dtoTo.userFavoritesToDao(dto));
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
