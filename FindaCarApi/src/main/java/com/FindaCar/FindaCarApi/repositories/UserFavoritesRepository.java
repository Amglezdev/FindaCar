package com.FindaCar.FindaCarApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FindaCar.FindaCarApi.entities.UserFavorites;

/**
 * The Interface UserFavoritesRepository.
 */
@Repository
public interface UserFavoritesRepository extends JpaRepository<UserFavorites, Long>{

}
