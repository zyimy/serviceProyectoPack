package com.restaurante.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.entity.Pack;
import com.restaurante.entity.Restaurante;
import com.restaurante.repository.PackRepository;
import com.restaurante.repository.RestauranteRepository;

@Service
public class PackService {
	
	@Autowired
	private PackRepository packRepository;
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	
	public Pack savePack(Pack pack,Long idRestaurante) {
		Restaurante restaurante =restauranteRepository.findById(idRestaurante).orElse(null);
		
		if (restaurante == null) {
			return null;
		}else {
			pack.setRestaurante(restaurante);
			return packRepository.save(pack);
		}
	}
	
	public List<Pack>allLista(){
		List<Pack>lista =packRepository.findAll();
		
		if (lista.isEmpty()) {
			return null;
			
		}else {
			return lista;
		}
	}
	
	public List<Pack>allNombre(Long id_restaurante){
		List<Pack>lista =packRepository.getByPackRestaurante(id_restaurante);
		
		if (lista.isEmpty()) {
			return null;
			
		}else {
			return lista;
		}
	}
	
	public List<Pack>getLista(){
		List<Pack>lista =packRepository.getByPackRestaurantes();
		
		if (lista.isEmpty()) {
			return null;
			
		}else {
			return lista;
		}
	}
	
	public Pack getRestaurant(Long idPack){
		Pack pack = packRepository.findById(idPack).orElse(null);
		
		
		if (pack == null) {
			return null;
			
		}else {
			return packRepository.getRestaurante(idPack);
		}
	}

}
