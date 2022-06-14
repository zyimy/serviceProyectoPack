package com.restaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.restaurante.config.BadRequestException;
import com.restaurante.dto.RestauranteDto;
import com.restaurante.entity.Pack;
import com.restaurante.entity.Restaurante;
import com.restaurante.entity.User;
import com.restaurante.mapper.RestauranteMapper;
import com.restaurante.model.PackModel;
import com.restaurante.repository.RestauranteRepository;

@Service
public class RestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private RestauranteMapper restauranteMapper;

	public RestauranteDto saveRestaurante(RestauranteDto restauranteDto) {

		Restaurante restaurante = restauranteMapper.restauranteToRestauranteDto(restauranteDto);

		restaurante.setDisponible(true);
		restauranteRepository.save(restaurante);

		return restauranteMapper.restauranteDtoToRestaurante(restaurante);

	}

	// BuscarUSuario
	public Restaurante buscarUsuario(String email, String contrasena) {
		return restauranteRepository.usuarioContrasena(email, contrasena);
	}

	public Restaurante saveRestaurantes(Restaurante restaurante) {

		return restauranteRepository.save(restaurante);

	}

	public List<RestauranteDto> allLista() {
		List<Restaurante> lista = restauranteRepository.findAll();

		if (lista.isEmpty()) {
			throw new BadRequestException("Lista vacia");

		} else {
			return restauranteMapper.restauranteDtoToRestaurante(lista);
		}
	}

	public List<Restaurante> ListaPack() {
		List<Restaurante> lista = restauranteRepository.listaRestaurantes();

		if (lista.isEmpty()) {
			return null;

		} else {
			return lista;
		}
	}

	public List<PackModel> listaPack(Long idRestaurante) {

		List<PackModel> lista = restTemplate.getForObject("http://service-packs/pack/getPack/" + idRestaurante,
				List.class);

		return lista;
	}

	public PackModel createPack(PackModel packModel, Long idRestaurante) {
		PackModel pack = restTemplate.postForObject("http://service-packst/pack", packModel, PackModel.class);

		return pack;
	}
}
