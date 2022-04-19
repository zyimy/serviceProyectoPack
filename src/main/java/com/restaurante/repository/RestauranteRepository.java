package com.restaurante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restaurante.entity.Pack;
import com.restaurante.entity.Restaurante;
import com.restaurante.entity.User;



@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
	
	@Query("from  Restaurante r  where r.email=?1 and r.contrasena=?2")
	Restaurante usuarioContrasena(String email, String contrasena);
	
	
	@Query("from  Restaurante r  where r.packs.size>0")
	List<Restaurante>listaRestaurantes();
	

	

	
	
	
	
	
	
	
	}
