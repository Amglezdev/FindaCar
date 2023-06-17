package com.FindaCar.FindaCarApi.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.FindaCar.FindaCarApi.entities.UserFavorites;
import com.FindaCar.FindaCarApi.repositories.UserFavoritesRepository;

@Component
public class UserFavoritesServiceImpl implements UserFavoritesService {

	@Autowired
	UserFavoritesRepository ufService;

	@Override
	public ArrayList<UserFavorites> findByUserId(long id) {
		try {
			return (ArrayList<UserFavorites>) ufService.findByUserId(id);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Override
	public boolean addFavorite(UserFavorites uf) {
		try {
			ufService.save(uf);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean removeFromFavorites(UserFavorites uf) {
		try {
			ufService.delete(uf);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public UserFavorites findById(Long id) {
		try {
			return ufService.findById(id).orElse(null);
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	

}
