package com.FindaCar.FindaCarApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FindaCar.FindaCarApi.entities.Role;

/**
 * The Interface RoleRepository.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
