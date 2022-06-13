package com.restaurante.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.dto.PackDto;
import com.restaurante.entity.Pack;
import com.restaurante.entity.Restaurante;
import com.restaurante.entity.User;
import com.restaurante.service.PackService;

@RestController
@RequestMapping("/pack")
@CrossOrigin("*")
public class PackController {
	
	Logger logger = LoggerFactory.getLogger(PackController.class);
	
	@Autowired
	private PackService packService;
	

	
	@PostMapping("/savePack/{id}")
	public ResponseEntity<PackDto>guardarUser(@RequestBody PackDto packDto ,@PathVariable("id") Long packId ){
		
		
		 packDto = packService.savePack(packDto, packId);
		
		if (packDto == null) {
		logger.error("No existe el id: "+packId);
		return ResponseEntity.noContent().build();
		
		}else {
			logger.info(" Pack Creado correctamente: "+packDto.getDescripcion()+" "+packDto.getDireccion());
			return ResponseEntity.ok(packDto);
			
		}
		
		
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<PackDto>>listaPack(){
		List<PackDto>lista = packService.allLista();
		
		if (lista.isEmpty()) {
			
			return ResponseEntity.noContent().build();
			
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@GetMapping("/listaNombre/{id_restaurante}")
	public ResponseEntity<List<Pack>>listaNombre(@PathVariable("id_restaurante") Long id_restaurante){
		List<Pack>lista = packService.allNombre(id_restaurante);
		
		if (lista.isEmpty()) {
			
			return ResponseEntity.noContent().build();
			
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@GetMapping("/listaNombre")
	public ResponseEntity<List<Pack>>listaPacks(){
		List<Pack>lista = packService.getLista();
		
		if (lista.isEmpty()) {
			
			return ResponseEntity.noContent().build();
			
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@GetMapping("/getRestaurante/{idPack}")
	public ResponseEntity<Pack>buscarRestaurante(@PathVariable("idPack") Long idPack){
		Pack restaurante = packService.getRestaurant(idPack);
		
		if (restaurante == null) {
			
			return ResponseEntity.noContent().build();
			
		}else {
			return ResponseEntity.ok(restaurante);
		}
	}

}
