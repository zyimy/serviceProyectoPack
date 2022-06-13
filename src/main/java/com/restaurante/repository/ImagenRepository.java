package com.restaurante.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restaurante.entity.Imagen;
import com.restaurante.entity.Pack;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen, Long> {
	
	@Query("FROM Imagen where pack.idPack =:idPack")
	List<Imagen>getByPackImagen(Long idPack);

}
