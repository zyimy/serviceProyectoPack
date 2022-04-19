package com.restaurante.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.engine.internal.Cascade;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_restaurante")
@Data
@NoArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Restaurante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id_restaurante;

	private String nombre_restaurante;

	private String email;

	private String contrasena;

	private String nombre_calle;

	private int numero_calle;

	private int codigo_postal;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "restaurante")
	@JsonManagedReference
	private List<Pack> packs = new ArrayList<>();
	


	public void addPacks(Pack pack) {
		this.packs.add(pack);
		pack.setRestaurante(this);
	}

	public Restaurante(String nombre_restaurante, String email, String contrasena, String nombre_calle,
			int numero_calle, int codigo_postal, List<Pack> packs) {
		super();
		this.nombre_restaurante = nombre_restaurante;
		this.email = email;
		this.contrasena = contrasena;
		this.nombre_calle = nombre_calle;
		this.numero_calle = numero_calle;
		this.codigo_postal = codigo_postal;
		this.packs = packs;
	}



}
