package com.restaurante.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.restaurante.dto.RestauranteDto;
import com.restaurante.entity.Restaurante;

@Mapper(componentModel = "Spring")
public interface RestauranteMapper {
	
	Restaurante restauranteToRestauranteDto(RestauranteDto restauranteDto);
	
	RestauranteDto restauranteDtoToRestaurante(Restaurante restaurante);
	
	List<Restaurante>RestauranteToRestauranteDto(List<RestauranteDto>restauranteDto);
	List<RestauranteDto>restauranteDtoToRestaurante(List<Restaurante>restaurante);

}
