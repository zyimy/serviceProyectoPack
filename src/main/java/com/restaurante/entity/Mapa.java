package com.restaurante.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_mapa")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mapa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idMapa;
	private Integer latitud;
	private Integer longitud;
	

	
}
