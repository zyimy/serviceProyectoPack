package com.restaurante.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restaurante.entity.Pack;
import com.restaurante.entity.Restaurante;

@Repository
public interface PackRepository extends JpaRepository<Pack, Long> {
	
	@Query("FROM Pack where restaurante.id_restaurante =:id_restaurante")
	List<Pack>getByPackRestaurante(Long id_restaurante);
	
	
	@Query("FROM Pack  where restaurante.id >=1")
	List<Pack>getByPackRestaurantes();
	
	@Query("FROM Pack p where p.id_pack =:id_pack")
	Pack getRestaurante(Long id_pack);

	
}
