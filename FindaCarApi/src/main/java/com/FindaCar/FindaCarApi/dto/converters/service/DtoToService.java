package com.FindaCar.FindaCarApi.dto.converters.service;

import java.util.ArrayList;

import com.FindaCar.FindaCarApi.dto.FuelDto;
import com.FindaCar.FindaCarApi.dto.MessagesDto;
import com.FindaCar.FindaCarApi.dto.PostDto;
import com.FindaCar.FindaCarApi.dto.RoleDto;
import com.FindaCar.FindaCarApi.dto.UserDto;
import com.FindaCar.FindaCarApi.dto.UserFavoritesDto;
import com.FindaCar.FindaCarApi.dto.VehicleDto;
import com.FindaCar.FindaCarApi.dto.VehiclePicturesDto;
import com.FindaCar.FindaCarApi.dto.VehicleTypeDto;
import com.FindaCar.FindaCarApi.entities.Fuel;
import com.FindaCar.FindaCarApi.entities.Messages;
import com.FindaCar.FindaCarApi.entities.Post;
import com.FindaCar.FindaCarApi.entities.Role;
import com.FindaCar.FindaCarApi.entities.User;
import com.FindaCar.FindaCarApi.entities.UserFavorites;
import com.FindaCar.FindaCarApi.entities.Vehicle;
import com.FindaCar.FindaCarApi.entities.VehiclePictures;
import com.FindaCar.FindaCarApi.entities.VehicleType;

// TODO: Auto-generated Javadoc
/**
 * The Interface DtoTo.
 */
public interface DtoToService {

	/**
	 * User to dao.
	 *
	 * @param dto the dto
	 * @return the user
	 */
	public User userToDao(UserDto dto);

	/**
	 * List user to dao.
	 *
	 * @param listDto the list dto
	 * @return the array list
	 */
	public ArrayList<User> listUserToDao(ArrayList<UserDto> listDto);

	/**
	 * Post to dao.
	 *
	 * @param dto the dto
	 * @return the post
	 */
	public Post postToDao(PostDto dto);

	/**
	 * List post to dto.
	 *
	 * @param listDto the list dto
	 * @return the array list
	 */
	public ArrayList<Post> listPostToDao(ArrayList<PostDto> listDto);

	/**
	 * Message to dao.
	 *
	 * @param dao the dao
	 * @return the messages
	 */
	public Messages messageToDao(MessagesDto dao);

	/**
	 * List messages to dao.
	 *
	 * @param listDto the list dto
	 * @return the array list
	 */
	public ArrayList<Messages> listMessagesToDao(ArrayList<MessagesDto> listDto);

	/**
	 * Role to dao.
	 *
	 * @param dto the dto
	 * @return the role
	 */
	public Role roleToDao(RoleDto dto);

	/**
	 * List role to dao.
	 *
	 * @param listDto the list dto
	 * @return the array list
	 */
	public ArrayList<Role> listRoleToDao(ArrayList<RoleDto> listDto);

	/**
	 * User favorites to dao.
	 *
	 * @param dto the dto
	 * @return the user favorites
	 */
	public UserFavorites userFavoritesToDao(UserFavoritesDto dto);

	/**
	 * Vehicle to dao.
	 *
	 * @param dto the dto
	 * @return the vehicle
	 */
	public Vehicle vehicleToDao(VehicleDto dto);

	/**
	 * List vehicle to dao.
	 *
	 * @param listDto the list dto
	 * @return the array list
	 */
	public ArrayList<Vehicle> listVehicleToDao(ArrayList<VehicleDto> listDto);

	/**
	 * Vehicle pictures to dao.
	 *
	 * @param dto the dto
	 * @return the vehicle pictures
	 */
	public VehiclePictures vehiclePicturesToDao(VehiclePicturesDto dto);

	/**
	 * List vehicle pictures dto.
	 *
	 * @param listDto the list dto
	 * @return the array list
	 */
	public ArrayList<VehiclePictures> listVehiclePicturesDto(ArrayList<VehiclePicturesDto> listDto);

	/**
	 * Vehicle type to dao.
	 *
	 * @param dto the dto
	 * @return the vehicle type
	 */
	public VehicleType vehicleTypeToDao(VehicleTypeDto dto);

	/**
	 * List vehicle type.
	 *
	 * @param listDto the list dto
	 * @return the array list
	 */
	public ArrayList<VehicleType> listVehicleType(ArrayList<VehicleTypeDto> listDto);

	/**
	 * Fuel to dto.
	 *
	 * @param dto the dto
	 * @return the fuel
	 */
	public Fuel fuelToDao(FuelDto dto);

	/**
	 * List fuel to dao.
	 *
	 * @param listDto the list dto
	 * @return the array list
	 */
	public ArrayList<Fuel> listFuelToDao(ArrayList<FuelDto> listDto);

}
