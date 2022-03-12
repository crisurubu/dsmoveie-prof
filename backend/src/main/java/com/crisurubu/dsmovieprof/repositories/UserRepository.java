package com.crisurubu.dsmovieprof.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crisurubu.dsmovieprof.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);

}
