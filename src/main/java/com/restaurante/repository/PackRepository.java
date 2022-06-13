package com.restaurante.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restaurante.entity.Pack;
import com.restaurante.entity.Restaurante;

@Repository
public interface PackRepository extends JpaRepository<Pack, Long> {
	
	@Query("FROM Pack where restaurante.idRestaurante =:idRestaurante")
	List<Pack>getByPackRestaurante(Long idRestaurante);
	
	
	@Query("FROM Pack  where restaurante.id >=1")
	List<Pack>getByPackRestaurantes();
	
	@Query("FROM Pack p where p.idPack =:idPack")
	Pack getRestaurante(Long idPack);

	
}
