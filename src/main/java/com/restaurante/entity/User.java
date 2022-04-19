package com.restaurante.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_user")
@Data
@NoArgsConstructor
public class User {
	
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id_user;
 
 private String nombre;
 
 private String email;
 
 private String contrasena;
 
 
public User(String nombre, String email, String contrasena) {
	super();
	this.nombre = nombre;
	this.email = email;
	this.contrasena = contrasena;

}
 
 
}
