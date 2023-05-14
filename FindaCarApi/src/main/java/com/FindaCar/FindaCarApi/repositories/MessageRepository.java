package com.FindaCar.FindaCarApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FindaCar.FindaCarApi.entities.Messages;

@Repository
public interface MessageRepository extends JpaRepository<Messages,Long >{
	

}
