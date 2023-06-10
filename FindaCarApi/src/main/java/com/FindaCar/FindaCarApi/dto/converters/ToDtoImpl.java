package com.FindaCar.FindaCarApi.dto.converters;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.FindaCar.FindaCarApi.dto.FuelDto;
import com.FindaCar.FindaCarApi.dto.MessagesDto;
import com.FindaCar.FindaCarApi.dto.PostDto;
import com.FindaCar.FindaCarApi.dto.RoleDto;
import com.FindaCar.FindaCarApi.dto.UserDto;
import com.FindaCar.FindaCarApi.dto.UserFavoritesDto;
import com.FindaCar.FindaCarApi.dto.VehicleDto;
import com.FindaCar.FindaCarApi.dto.VehiclePicturesDto;
import com.FindaCar.FindaCarApi.dto.VehicleTypeDto;
import com.FindaCar.FindaCarApi.dto.converters.service.ToDtoService;
import com.FindaCar.FindaCarApi.entities.Fuel;
import com.FindaCar.FindaCarApi.entities.Messages;
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
		dto.setRol(roleToDto(user.getRole()));
		dto.setSurname(user.getSurname());
		dto.setSecurity(user.getSecurity());

		System.out.println(dto.toString());

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
		dto.setVehicleId(vehicleToDto(post.getVehicle()));

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

		dto.setName(dao.getName());

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
		dto.setUser(userToDto(dao.getUser()));
		dto.setVehicle(vehicleToDto(dao.getVehicle()));

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
		dto.setType(vehicleTypeToDto(dao.getType()));
		dto.setOwner(userToDto(dao.getOwner()));
		dto.setFuel(fuelToDto(dao.getFuel()));

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
		dto.setVehicle(vehicleToDto(dao.getVehicle()));

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

		dto.setName(dao.getName());

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

	@Override
	public MessagesDto messageToDto(Messages message) {

		MessagesDto dto = new MessagesDto();

		dto.setId(message.getId());
		dto.setReciever(userToDto(message.getReciever()));
		dto.setSender(userToDto(message.getSender()));
		dto.setContent(message.getContent());
		
		System.out.println(dto.toString());

		return dto;
	}

	@Override
	public ArrayList<MessagesDto> listMessagesToDto(ArrayList<Messages> listDao) {

		ArrayList<MessagesDto> listDto = new ArrayList<>();

		for (Messages messages : listDao) {
			listDto.add(messageToDto(messages));
		}
		return listDto;

	}

	@Override
	public FuelDto fuelToDto(Fuel dao) {

		FuelDto dto = new FuelDto();

		dto.setName(dao.getName());

		return dto;

	}

	@Override
	public ArrayList<FuelDto> listFuelToDto(ArrayList<Fuel> listDao) {

		ArrayList<FuelDto> listDto = new ArrayList<>();

		for (Fuel fuel : listDao) {
			listDto.add(fuelToDto(fuel));
		}

		return listDto;

	}

}
