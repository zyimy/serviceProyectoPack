package com.restaurante.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.hibernate.loader.plan.exec.process.internal.AbstractRowReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.config.BadRequestException;
import com.restaurante.config.NotFoundException;
import com.restaurante.dto.PackDto;
import com.restaurante.entity.Pack;
import com.restaurante.entity.Restaurante;
import com.restaurante.mapper.PackMapper;
import com.restaurante.repository.PackRepository;
import com.restaurante.repository.RestauranteRepository;

@Service
public class PackService {

	@Autowired
	private PackRepository packRepository;

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private PackMapper packMapper;

	public PackDto savePack(PackDto packDto, Long idRestaurante) {
		Restaurante restaurante = restauranteRepository.findById(idRestaurante).orElse(null);

		Pack pack = packMapper.packToPackDto(packDto);

		if (restaurante == null) {
			throw new NotFoundException("Restaurante no encontrado: " + idRestaurante);
		} else {

			pack.setRestaurante(restaurante);

	
			packRepository.save(pack);

			

			return packMapper.packDtoToPack(pack);
		}
	}

	public List<PackDto> allLista() {
		List<Pack> lista = packRepository.findAll();

		if (lista.isEmpty()) {
			throw new BadRequestException("lista vacia");

		} else {
			return packMapper.listPackDtoToListPack(lista);
		}
	}

	public List<Pack> allNombre(Long id_restaurante) {
		List<Pack> lista = packRepository.getByPackRestaurante(id_restaurante);

		if (lista.isEmpty()) {
			return null;

		} else {
			return lista;
		}
	}

	public List<Pack> getLista() {
		List<Pack> lista = packRepository.getByPackRestaurantes();

		if (lista.isEmpty()) {
			return null;

		} else {
			return lista;
		}
	}

	public Pack getRestaurant(Long idPack) {
		Pack pack = packRepository.findById(idPack).orElse(null);

		if (pack == null) {
			return null;

		} else {
			return packRepository.getRestaurante(idPack);
		}
	}

}
