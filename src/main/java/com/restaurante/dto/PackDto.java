package com.restaurante.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PackDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	@JsonProperty("id_pack")
	private Long idPack;

	@NotBlank
	@JsonProperty("nombre")
	private String nombre;
	
	@NotBlank
	@JsonProperty("descripcion")
	private String descripcion;
	
	@NotBlank
	@JsonProperty("imagen")
	private String imagen;
	
	@NotBlank
	@JsonProperty("status")
	private String status;
	
	@NotBlank
	@JsonProperty("hora_disponible")
	private String horaDisponible;
	
	@NotBlank
	@JsonProperty("hora_no_disponible")
	private String horaNoDisponible;
	
	@NotBlank
	@JsonProperty("direccion")
	private String direccion;
	
	@NotNull
	@JsonProperty("precio")
	private double precio;
	
	
	@NotBlank
	@JsonProperty("fecha")
	private String fecha;


}
