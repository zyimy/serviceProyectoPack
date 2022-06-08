package com.restaurante.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurante.entity.Mapa;

@Repository
public interface MapaRepository extends JpaRepository<Mapa, Integer> {
	
	

}
