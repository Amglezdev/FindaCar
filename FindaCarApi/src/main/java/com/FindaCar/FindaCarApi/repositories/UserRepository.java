package com.FindaCar.FindaCarApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
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

	public User findByMailAndPassword(String mail, String password);
	
	/**
	 * Exists by mail and password.
	 *
	 * @param mail the mail
	 * @param password the password
	 * @return true, if successful
	 */
	public boolean existsByMailAndPassword(String mail, String password);
	
	/**
	 * Exists by mail.
	 *
	 * @param mail the mail
	 * @return true, if successful
	 */
	public boolean existsByMailAndSecurity(String mail, String security);
	
	public User findByMail(String mail);
	
	
	

}
