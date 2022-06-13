package com.restaurante.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_pack")
@Data
@NoArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Pack {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPack;

	private String nombre;

	private String descripcion;

	private String imagen;

	private String status;

	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime horaDisponible;

	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalTime horaNoDisponible;

	private String direccion;

	private double precio;

	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	private LocalDate fecha;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_restaurante")
	@JsonBackReference
	private Restaurante restaurante;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pack")
	@JsonManagedReference
	private List<Imagen> imagenes = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_ventas", referencedColumnName = "id_ventas")
	private Ventas ventas;

	public Pack(String nombre, String descripcion, String imagen, String direccion, double precio, LocalDate fecha,
			Restaurante restaurante) {

		this.nombre = nombre;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.direccion = direccion;
		this.precio = precio;
		this.fecha = fecha;
		this.restaurante = restaurante;

	}

}
