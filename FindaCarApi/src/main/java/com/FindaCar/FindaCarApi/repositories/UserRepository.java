package com.FindaCar.FindaCarApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.FindaCar.FindaCarApi.entities.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserRepository.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * Find user by mail and password.
	 *
	 * @param mail     the mail
	 * @param password the password
	 * @return the user
	 */
	@Query("SELECT U FROM USER U WHERE U.MAIL = :mail AND U.password")
	public User findUserByMailAndPassword(String mail, String password);

}