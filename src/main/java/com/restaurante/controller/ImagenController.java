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

import com.restaurante.entity.Imagen;
import com.restaurante.entity.Pack;
import com.restaurante.service.ImagenService;

@RestController
@RequestMapping("/imagen")
@CrossOrigin("*")
public class ImagenController {
	
	@Autowired
	private ImagenService imagenService;
	
	
	@PostMapping("/saveImagen/{idPack}")
	public ResponseEntity<Imagen>guardarImagen(@RequestBody Imagen imagen ,@PathVariable("idPack") Long idPack ){
		
		Imagen imagen1 = imagenService.savePack(imagen, idPack);
		
		if (imagen1 == null) {
		return ResponseEntity.noContent().build();	
		}else {
			return ResponseEntity.ok(imagen1);
		}
		
		
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<Imagen>>listaPack(){
		List<Imagen>lista = imagenService.allLista();
		
		if (lista.isEmpty()) {
			
			return ResponseEntity.noContent().build();
			
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@GetMapping("/listaImagen/{idPack}")
	public ResponseEntity<List<Imagen>>listaNombre(@PathVariable("idPack") Long idPack){
		List<Imagen>lista = imagenService.allNombre(idPack);
		
		if (lista.isEmpty()) {
			
			return ResponseEntity.noContent().build();
			
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	

}
