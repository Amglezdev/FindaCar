package com.FindaCar.FindaCarApi.dto.converters.service;

import java.util.ArrayList;

import com.FindaCar.FindaCarApi.dto.PostDto;
import com.FindaCar.FindaCarApi.dto.UserDto;
import com.FindaCar.FindaCarApi.entities.Post;
import com.FindaCar.FindaCarApi.entities.User;

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
	public ArrayList<Post> listPostToDto(ArrayList<PostDto> listDto);
	
	
	

 
}
