package com.FindaCar.FindaCarApi.dto.converters.service;

import java.util.ArrayList;

import com.FindaCar.FindaCarApi.dto.PostDto;
import com.FindaCar.FindaCarApi.dto.UserDto;
import com.FindaCar.FindaCarApi.entities.Post;
import com.FindaCar.FindaCarApi.entities.User;

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
	 * @param listDto the list dto
	 * @return the array list
	 */
	public ArrayList<UserDto> listUserToDto(ArrayList<User> listDto);
	
	/**
	 * Post to dto.
	 *
	 * @param post the post
	 * @return the post dto
	 */
	public PostDto postToDto(PostDto post);
	
	/**
	 * List post to dto.
	 *
	 * @param listDto the list dto
	 * @return the array list
	 */
	public ArrayList<PostDto> listPostToDto(ArrayList<Post> listDto);
	
	

}
