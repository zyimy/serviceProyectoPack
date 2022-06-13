package com.restaurante.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class RestauranteDto implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	
	@NotNull
	@JsonProperty("id_restaurante")
	private Long idRestaurante;

	
	@NotBlank
	@JsonProperty("nombre")
	private String nombre;
	
	@NotBlank
	@JsonProperty("email")
	private String email;

	@NotBlank
	@JsonProperty("contrasena")
	private String contrasena;

	@NotBlank
	@JsonProperty("nombre_calle")
	private String nombreCalle;

	@NotNull
	@JsonProperty("numero_calle")
	private int numeroCalle;

	@NotNull
	@JsonProperty("codigo_postal")
	private int codigoPostal;
	
	@NotNull
	@JsonProperty("latitud")
	private Double latitud;
	
	@NotNull
	@JsonProperty("longitud")
	private Double longitud;
	
	@NotNull
	@JsonProperty("disponible")
	private Boolean disponible;

}
