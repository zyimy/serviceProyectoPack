package com.restaurante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restaurante.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("from  User u  where u.email=?1 and u.contrasena=?2")
	User usuarioContrasena(String email, String contrasena);
	

}
