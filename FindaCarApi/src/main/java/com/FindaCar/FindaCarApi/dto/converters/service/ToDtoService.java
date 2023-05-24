package com.FindaCar.FindaCarApi.dto.converters.service;

import java.util.ArrayList;

import com.FindaCar.FindaCarApi.dto.MessagesDto;
import com.FindaCar.FindaCarApi.dto.PostDto;
import com.FindaCar.FindaCarApi.dto.RoleDto;
import com.FindaCar.FindaCarApi.dto.UserDto;
import com.FindaCar.FindaCarApi.dto.UserFavoritesDto;
import com.FindaCar.FindaCarApi.dto.VehicleDto;
import com.FindaCar.FindaCarApi.dto.VehiclePicturesDto;
import com.FindaCar.FindaCarApi.dto.VehicleTypeDto;
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
 * The Interface ToDtoService.
 */
public interface ToDtoService {

	/**
	 * User to dto.
	 *
	 * @param user the user
	 * @return the user dto
	 */
	public UserDto userToDto(User user);

	/**
	 * List user to dto.
	 *
	 * @param listDao the list dao
	 * @return the array list
	 */
	public ArrayList<UserDto> listUserToDto(ArrayList<User> listDao);

	/**
	 * Post to dto.
	 *
	 * @param post the post
	 * @return the post dto
	 */
	public PostDto postToDto(Post post);

	/**
	 * List post to dto.
	 *
	 * @param listDao the list dao
	 * @return the array list
	 */
	public ArrayList<PostDto> listPostToDto(ArrayList<Post> listDao);

	/**
	 * Role to dto.
	 *
	 * @param dao the dao
	 * @return the role dto
	 */
	public RoleDto roleToDto(Role dao);

	/**
	 * List role to dto.
	 *
	 * @param listDao the list dao
	 * @return the array list
	 */
	public ArrayList<RoleDto> listRoleToDto(ArrayList<Role> listDao);

	/**
	 * User favorites to dto.
	 *
	 * @param dao the dao
	 * @return the user favorites dto
	 */
	public UserFavoritesDto userFavoritesToDto(UserFavorites dao);

	/**
	 * List user favorites to dto.
	 *
	 * @param listDao the list dao
	 * @return the array list
	 */
	public ArrayList<UserFavoritesDto> listUserFavoritesToDto(ArrayList<UserFavorites> listDao);

	/**
	 * Vehicle to dto.
	 *
	 * @param vehicle the vehicle
	 * @return the vehicle dto
	 */
	public VehicleDto vehicleToDto(Vehicle vehicle);

	/**
	 * List vehicle to dto.
	 *
	 * @param listDao the list dao
	 * @return the array list
	 */
	public ArrayList<VehicleDto> listVehicleToDto(ArrayList<Vehicle> listDao);

	/**
	 * Vehicle pictures to dto.
	 *
	 * @param dao the dao
	 * @return the vehicle pictures dto
	 */
	public VehiclePicturesDto vehiclePicturesToDto(VehiclePictures dao);

	/**
	 * List vehicle pictures to dto.
	 *
	 * @param listDao the list dao
	 * @return the array list
	 */
	public ArrayList<VehiclePicturesDto> listVehiclePicturesToDto(ArrayList<VehiclePictures> listDao);

	/**
	 * Vehicle type to dto.
	 *
	 * @param dao the dao
	 * @return the vehicle type dto
	 */
	public VehicleTypeDto vehicleTypeToDto(VehicleType dao);

	/**
	 * List vehicle type to dto.
	 *
	 * @param listDao the list dao
	 * @return the array list
	 */
	public ArrayList<VehicleTypeDto> listVehicleTypeToDto(ArrayList<VehicleType> listDao);

	/**
	 * Message to dto.
	 *
	 * @param message the message
	 * @return the messages dto
	 */
	public MessagesDto messageToDto(Messages message);

	/**
	 * List messages to dto.
	 *
	 * @param listDao the list dao
	 * @return the array list
	 */
	public ArrayList<MessagesDto> listMessagesToDto(ArrayList<Messages> listDao);
	
	

}
