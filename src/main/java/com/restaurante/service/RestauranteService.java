package com.restaurante.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.dto.RestauranteDto;
import com.restaurante.entity.Pack;
import com.restaurante.entity.Restaurante;
import com.restaurante.entity.User;
import com.restaurante.repository.RestauranteRepository;


@Service
public class RestauranteService {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	

	
	public Restaurante saveRestaurante(RestauranteDto restaurante) {
	    //Pack pack = new Pack();
	    //pack.setRestaurante(restaurante.getRestaurante());
	    //restaurante.getRestaurante().addPacks(pack);
		return restauranteRepository.save(restaurante.getRestaurante());
		
	}
	
	//BuscarUSuario
	public Restaurante buscarUsuario(String email, String  contrasena) {
		return restauranteRepository.usuarioContrasena(email, contrasena);
	}
	
	public Restaurante saveRestaurantes(Restaurante restaurante) {

		return restauranteRepository.save(restaurante);
		
	}
	
	public List<Restaurante>allLista(){
		List<Restaurante>lista =restauranteRepository.findAll();
		
		if (lista.isEmpty()) {
			return null;
			
		}else {
			return lista;
		}
	}
	
	public List<Restaurante>ListaPack(){
		List<Restaurante>lista =restauranteRepository.listaRestaurantes();
		
		if (lista.isEmpty()) {
			return null;
			
		}else {
			return lista;
		}
	}
}
