package com.FindaCar.FindaCarApi.services;

import java.util.ArrayList;

import com.FindaCar.FindaCarApi.entities.UserFavorites;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserFavoritesService.
 */
public interface UserFavoritesService {

	/**
	 * Find by user id.
	 *
	 * @param id the id
	 * @return the array list
	 */
	public ArrayList<UserFavorites> findByUserId(long id);

	/**
	 * Adds the favorite.
	 *
	 * @param uf the uf
	 * @return true, if successful
	 */
	public boolean addFavorite(UserFavorites uf);

	/**
	 * Removes the from favorites.
	 *
	 * @param uf the uf
	 * @return true, if successful
	 */
	public boolean removeFromFavorites(UserFavorites uf);

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the user favorites
	 */
	public UserFavorites findById(Long id);

}
