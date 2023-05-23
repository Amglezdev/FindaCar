package com.FindaCar.FindaCarApi.dto.converters;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.FindaCar.FindaCarApi.dto.PostDto;
import com.FindaCar.FindaCarApi.dto.RoleDto;
import com.FindaCar.FindaCarApi.dto.UserDto;
import com.FindaCar.FindaCarApi.dto.UserFavoritesDto;
import com.FindaCar.FindaCarApi.dto.VehicleDto;
import com.FindaCar.FindaCarApi.dto.VehiclePicturesDto;
import com.FindaCar.FindaCarApi.dto.VehicleTypeDto;
import com.FindaCar.FindaCarApi.dto.converters.service.ToDtoService;
import com.FindaCar.FindaCarApi.entities.Post;
import com.FindaCar.FindaCarApi.entities.Role;
import com.FindaCar.FindaCarApi.entities.User;
import com.FindaCar.FindaCarApi.entities.UserFavorites;
import com.FindaCar.FindaCarApi.entities.Vehicle;
import com.FindaCar.FindaCarApi.entities.VehiclePictures;
import com.FindaCar.FindaCarApi.entities.VehicleType;

@Component
public class ToDtoImpl implements ToDtoService {

	@Override
	public UserDto userToDto(User user) {
		UserDto dto = new UserDto();

		dto.setId(user.getId());
		dto.setMail(user.getMail());
		dto.setName(user.getName());
		dto.setPassword(user.getPassword());
		dto.setPhoneNumber(user.getPhoneNumber());
		dto.setRolId(user.getRole().getId());

		return dto;
	}

	@Override
	public ArrayList<UserDto> listUserToDto(ArrayList<User> listDto) {

		ArrayList<UserDto> listUser = new ArrayList<>();

		for (User user : listDto) {
			listUser.add(userToDto(user));
		}

		return listUser;
	}

	@Override
	public PostDto postToDto(Post post) {
		PostDto dto = new PostDto();

		dto.setComment(post.getComment());
		dto.setId(post.getId());
		dto.setVehicleId(post.getVehicle().getId());

		return dto;
	}

	@Override
	public ArrayList<PostDto> listPostToDto(ArrayList<Post> listDao) {

		ArrayList<PostDto> listDto = new ArrayList<>();

		for (Post post : listDao) {
			listDto.add(postToDto(post));
		}

		return listDto;

	}

	@Override
	public RoleDto roleToDto(Role dao) {

		RoleDto dto = new RoleDto();

		dto.setDescRol(dao.getDescription());
		dto.setId(dao.getId());
		dto.setRol(dao.getRole());

		return dto;
	}

	@Override
	public ArrayList<RoleDto> listRoleToDto(ArrayList<Role> listDao) {

		ArrayList<RoleDto> listDto = new ArrayList<>();

		for (Role role : listDao) {
			listDto.add(roleToDto(role));
		}
		return listDto;
	}

	@Override
	public UserFavoritesDto userFavoritesToDto(UserFavorites dao) {

		UserFavoritesDto dto = new UserFavoritesDto();

		dto.setId(dao.getId());
		dto.setUserId(dao.getUser().getId());
		dto.setVehicleId(dao.getVehicle().getId());

		return dto;
	}

	@Override
	public ArrayList<UserFavoritesDto> listUserFavoritesToDto(ArrayList<UserFavorites> listDao) {

		ArrayList<UserFavoritesDto> listDto = new ArrayList<>();

		for (UserFavorites userFavorites : listDao) {
			listDto.add(userFavoritesToDto(userFavorites));
		}
		return listDto;
	}

	@Override
	public VehicleDto vehicleToDto(Vehicle dao) {

		VehicleDto dto = new VehicleDto();

		dto.setAge(dao.getAge());
		dto.setBrand(dao.getBrand());
		dto.setId(dao.getId());
		dto.setMileage(dao.getMileage());
		dto.setModel(dao.getModel());
		dto.setPower(dao.getPower());
		dto.setPrice(dao.getPrice());
		dto.setTypeId(dao.getType().getId());
		dto.setUserId(dao.getOwner().getId());

		return dto;
	}

	@Override
	public ArrayList<VehicleDto> listVehicleToDto(ArrayList<Vehicle> listDao) {

		ArrayList<VehicleDto> listDto = new ArrayList<>();

		for (Vehicle vehicle : listDao) {
			listDto.add(vehicleToDto(vehicle));
		}
		return listDto;
	}

	@Override
	public VehiclePicturesDto vehiclePicturesToDto(VehiclePictures dao) {

		VehiclePicturesDto dto = new VehiclePicturesDto();

		dto.setId(dao.getId());
		dto.setImage(dao.getImage());
		dto.setVehicleId(dao.getVehicle().getId());

		return dto;

	}

	@Override
	public ArrayList<VehiclePicturesDto> listVehiclePicturesToDto(ArrayList<VehiclePictures> listDao) {

		ArrayList<VehiclePicturesDto> listDto = new ArrayList<>();

		for (VehiclePictures vehiclePictures : listDao) {
			listDto.add(vehiclePicturesToDto(vehiclePictures));
		}

		return listDto;

	}

	@Override
	public VehicleTypeDto vehicleTypeToDto(VehicleType dao) {

		VehicleTypeDto dto = new VehicleTypeDto();

		dto.setId(dao.getId());
		dto.setType(dao.getType());

		return dto;

	}

	@Override
	public ArrayList<VehicleTypeDto> listVehicleTypeToDto(ArrayList<VehicleType> listDao) {

		ArrayList<VehicleTypeDto> listDto = new ArrayList<>();

		for (VehicleType vehicleType : listDao) {
			listDto.add(vehicleTypeToDto(vehicleType));
		}
		return listDto;

	}

}
