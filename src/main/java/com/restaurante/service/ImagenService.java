package com.restaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.entity.Imagen;
import com.restaurante.entity.Pack;
import com.restaurante.entity.Restaurante;
import com.restaurante.repository.ImagenRepository;
import com.restaurante.repository.PackRepository;

@Service
public class ImagenService {
	
	@Autowired
	private ImagenRepository imagenRepository;
	
	@Autowired
	private PackRepository packRepository;
	
	public Imagen savePack(Imagen imagen,Long idPack) {
		Pack pack = packRepository.findById(idPack).orElse(null);
		
		if (pack == null) {
			return null;
		}else {
			imagen.setPack(pack);
			return imagenRepository.save(imagen);
		}
	}
	
	public List<Imagen>allLista(){
		List<Imagen>lista = imagenRepository.findAll();
		
		if (lista.isEmpty()) {
			return null;
			
		}else {
			return lista;
		}
	}
	
	public List<Imagen>allNombre(Long id_pack){
		List<Imagen>lista =imagenRepository.getByPackImagen(id_pack);
		
		if (lista.isEmpty()) {
			return null;
			
		}else {
			return lista;
		}
	}
	


}
