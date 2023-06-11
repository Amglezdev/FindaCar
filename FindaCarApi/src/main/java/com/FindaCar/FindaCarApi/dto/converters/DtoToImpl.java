package com.FindaCar.FindaCarApi.dto.converters;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.FindaCar.FindaCarApi.dto.converters.service.DtoToService;
import com.FindaCar.FindaCarApi.entities.Fuel;
import com.FindaCar.FindaCarApi.entities.Messages;
import com.FindaCar.FindaCarApi.entities.Post;
import com.FindaCar.FindaCarApi.entities.Role;
import com.FindaCar.FindaCarApi.entities.User;
import com.FindaCar.FindaCarApi.entities.UserFavorites;
import com.FindaCar.FindaCarApi.entities.Vehicle;
import com.FindaCar.FindaCarApi.entities.VehiclePictures;
import com.FindaCar.FindaCarApi.entities.VehicleType;
import com.FindaCar.FindaCarApi.services.FuelServiceImpl;
import com.FindaCar.FindaCarApi.services.RoleServiceImpl;
import com.FindaCar.FindaCarApi.services.UserServiceImpl;
import com.FindaCar.FindaCarApi.services.VehicleServiceImpl;
import com.FindaCar.FindaCarApi.services.VehicleTypeServiceImpl;

@Component
public class DtoToImpl implements DtoToService {

	private String mdUuid = UUID.randomUUID().toString();
	private Calendar calendar = Calendar.getInstance();

	@Autowired
	RoleServiceImpl roleService;
	@Autowired
	UserServiceImpl userService;
	@Autowired
	VehicleServiceImpl vehicleService;
	@Autowired
	VehicleTypeServiceImpl vtService;
	@Autowired
	FuelServiceImpl fService;

	@Override
	public User userToDao(UserDto dto) {

		User dao = new User();

		dao.setId(dto.getId());
		dao.setMail(dto.getMail());
		dao.setMdDate(calendar);
		dao.setMdUuid(mdUuid);
		dao.setName(dto.getName());
		dao.setPassword(dto.getPassword());
		dao.setPhoneNumber(dto.getPhoneNumber());
		dao.setRole(roleService.getRoleById(dto.getRol().getName()));
		dao.setSurname(dto.getSurname());
		dao.setSecurity(dto.getSecurity());

		System.out.println(dao.toString());

		return dao;
	}

	@Override
	public ArrayList<User> listUserToDao(ArrayList<UserDto> listDao) {
		ArrayList<User> listUser = new ArrayList<>();

		for (UserDto user : listDao) {
			listUser.add(userToDao(user));
		}
		return listUser;

	}

	@Override
	public Post postToDao(PostDto dto) {
		Post dao = new Post();
				
		dao.setComment(dto.getComment());
		dao.setId(dto.getId());
		dao.setMdDate(calendar);
		dao.setMdUuid(mdUuid);
		dao.setVehicle(vehicleToDao(dto.getVehicle()));		

		return dao;
	}

	@Override
	public ArrayList<Post> listPostToDao(ArrayList<PostDto> listDto) {
		// TODO Auto-generated method stub
		ArrayList<Post> listDao = new ArrayList<>();

		for (PostDto dto : listDto) {
			listDao.add(postToDao(dto));
		}

		return listDao;
	}

	@Override
	public Messages messageToDao(MessagesDto dto) {
		// TODO Auto-generated method stub
		Messages dao = new Messages();

		dao.setId(dto.getId());
		dao.setMdDate(calendar);
		dao.setMdUuid(mdUuid);
		dao.setReciever(userService.findById(dto.getReciever().getId()));
		dao.setSender(userService.findById(dto.getSender().getId()));
		dao.setContent(dto.getContent());
			
		System.out.println(dao.toString());

		return dao;
	}

	@Override
	public ArrayList<Messages> listMessagesToDao(ArrayList<MessagesDto> listDto) {

		ArrayList<Messages> listDao = new ArrayList<>();

		for (MessagesDto messages : listDto) {
			listDao.add(messageToDao(messages));
		}

		return listDao;
	}

	@Override
	public Role roleToDao(RoleDto dto) {

		Role dao = new Role();

		dao.setName(dto.getName());

		return dao;
	}

	@Override
	public ArrayList<Role> listRoleToDao(ArrayList<RoleDto> listDto) {

		ArrayList<Role> listDao = new ArrayList<>();

		for (RoleDto role : listDto) {
			listDao.add(roleToDao(role));
		}

		return listDao;
	}

	@Override
	public UserFavorites userFavoritesToDao(UserFavoritesDto dto) {

		UserFavorites uf = new UserFavorites();

		uf.setId(dto.getId());
		uf.setMdDate(calendar);
		uf.setMdUuid(mdUuid);
		uf.setUser(userService.findById(dto.getId()));
		uf.setVehicle(vehicleService.findById(dto.getVehicle().getId()));

		return uf;
	}

	@Override
	public Vehicle vehicleToDao(VehicleDto dto) {

		Vehicle dao = new Vehicle();

		dao.setAge(dto.getAge());
		dao.setBrand(dto.getBrand());
		dao.setId(dto.getId());
		dao.setMdDate(calendar);
		dao.setMdUuid(mdUuid);
		dao.setMileage(dto.getMileage());
		dao.setModel(dto.getModel());
		dao.setOwner(userService.findById(dto.getOwner().getId()));
		dao.setPower(dto.getPower());
		dao.setPrice(dto.getPrice());
		dao.setType(vehicleTypeToDao(dto.getType()));
		dao.setFuel(fService.findById(dto.getFuel().getName()));

		return dao;

	}

	@Override
	public ArrayList<Vehicle> listVehicleToDao(ArrayList<VehicleDto> listDto) {

		ArrayList<Vehicle> listDao = new ArrayList<>();

		for (VehicleDto vehicle : listDto) {
			listDao.add(vehicleToDao(vehicle));
		}

		return listDao;
	}

	@Override
	public VehiclePictures vehiclePicturesToDao(VehiclePicturesDto dto) {

		VehiclePictures dao = new VehiclePictures();

		dao.setId(dto.getId());
		dao.setImage(dto.getImage());
		dao.setMdDate(calendar);
		dao.setMdUuid(mdUuid);
		dao.setVehicle(vehicleService.findById(dto.getVehicle().getId()));

		return dao;
	}

	@Override
	public ArrayList<VehiclePictures> listVehiclePicturesDto(ArrayList<VehiclePicturesDto> listDto) {
		ArrayList<VehiclePictures> listDao = new ArrayList<>();

		for (VehiclePicturesDto vehiclePictures : listDto) {
			vehiclePicturesToDao(vehiclePictures);
		}

		return listDao;
	}

	@Override
	public VehicleType vehicleTypeToDao(VehicleTypeDto dto) {

		VehicleType dao = new VehicleType();

		dao.setName(dto.getName());

		return dao;

	}

	@Override
	public ArrayList<VehicleType> listVehicleType(ArrayList<VehicleTypeDto> listDto) {

		ArrayList<VehicleType> listDao = new ArrayList<>();

		for (VehicleTypeDto vehicleType : listDto) {
			listDao.add(vehicleTypeToDao(vehicleType));
		}

		return listDao;

	}

	@Override
	public Fuel fuelToDao(FuelDto dto) {

		Fuel dao = new Fuel();

		dao.setName(dto.getName());

		return dao;
	}

	@Override
	public ArrayList<Fuel> listFuelToDao(ArrayList<FuelDto> listDto) {

		ArrayList<Fuel> listDao = new ArrayList<>();

		for (FuelDto fuel : listDto) {
			listDao.add(fuelToDao(fuel));
		}

		return listDao;

	}

}
