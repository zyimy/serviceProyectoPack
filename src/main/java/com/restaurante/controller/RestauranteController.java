package com.restaurante.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.dto.RestauranteDto;
import com.restaurante.entity.Restaurante;
import com.restaurante.entity.User;
import com.restaurante.service.RestauranteService;



@RestController
@RequestMapping("/restaurante")
@CrossOrigin("*")
public class RestauranteController {
	
	@Autowired
	private RestauranteService restauranteService;
	
	
	
	@PostMapping
	public ResponseEntity<Restaurante>save(@RequestBody RestauranteDto restaurante){
		
	return ResponseEntity.ok(restauranteService.saveRestaurante(restaurante));
			
	}
	
	
	@PostMapping("/guardar")
	public ResponseEntity<Restaurante>saveRestaurante(@RequestBody Restaurante restaurante){
		
	return ResponseEntity.ok(restauranteService.saveRestaurantes(restaurante));
			
	}
	
	//Buscar usuario
	
	@GetMapping("/usuario/{email}/{contrasena}")
	public ResponseEntity<Restaurante>buscarRestaurante(@PathVariable("email")String email,@PathVariable("contrasena")String contrasena){
		Restaurante restaurante = restauranteService.buscarUsuario(email, contrasena);
		
		if (restaurante == null) {
			return ResponseEntity.notFound().build();
			
		}else {
			return ResponseEntity.ok(restaurante);
		}
	}
	
	
	@GetMapping("/lista")
	public ResponseEntity<List<Restaurante>>listaPack(){
		List<Restaurante>lista = restauranteService.allLista();
		
		if (lista.isEmpty()) {
			
			return ResponseEntity.noContent().build();
			
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@GetMapping("/listaPack")
	public ResponseEntity<List<Restaurante>>listasPack(){
		List<Restaurante>lista = restauranteService.ListaPack();
		
		if (lista.isEmpty()) {
			
			return ResponseEntity.noContent().build();
			
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	

}
