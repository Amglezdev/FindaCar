package com.FindaCar.FindaCarApi.services;

import java.util.ArrayList;

import com.FindaCar.FindaCarApi.entities.Post;

// TODO: Auto-generated Javadoc
/**
 * The Interface PostService.
 */
public interface PostService {
	
	/**
	 * Find all post.
	 *
	 * @return the array list
	 */
	public ArrayList<Post> findAllPost();
	
	/**
	 * Adds the post.
	 *
	 * @param post the post
	 * @return true, if successful
	 */
	public boolean addPost(Post post);
	
	/**
	 * Delete post.
	 *
	 * @param id the id
	 * @return true, if successful
	 */
	public boolean deletePost(Long id);
	
	/**
	 * Update post.
	 *
	 * @param post the post
	 * @return true, if successful
	 */
	public boolean updatePost(Post post);
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the post
	 */
	public Post findById(Long id);
	
	

}
