package com.restaurante.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.restaurante.dto.PackDto;
import com.restaurante.entity.Pack;



@Mapper(componentModel = "Spring")
public interface PackMapper {
	
	Pack packToPackDto(PackDto packDto);
	
	PackDto packDtoToPack(Pack pack);
	
	List<Pack>listPackToListPackDto(List<PackDto>listDto);
	List<PackDto>listPackDtoToListPack(List<Pack>listPack);
	

}
