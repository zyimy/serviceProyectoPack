package com.restaurante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.dto.UserDto;
import com.restaurante.entity.User;
import com.restaurante.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	//Buscar usuario
	
	@GetMapping("/usuario/{email}/{contrasena}")
	public ResponseEntity<User>buscarUser(@PathVariable("email")String email,@PathVariable("contrasena")String contrasena){
		User user = userService.buscarUsuario(email, contrasena);
		
		if (user == null) {
			return ResponseEntity.notFound().build();
			
		}else {
			return ResponseEntity.ok(user);
		}
	}
	
	
	//guardar
	@PostMapping
	public ResponseEntity<User>guardarUser(@RequestBody User user){
	   User user2 = userService.saveUser(user);
	   
	   return ResponseEntity.ok(user); //200
	}
	
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<User>buscarUsers( @PathVariable("id")Long id){
		User user2 = userService.buscarUser(id);
		
		if (user2 == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(user2);
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>>listaUser(){
		List<User>lista = userService.ListaUsuarios();
		
		if (lista.isEmpty()) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.ok(lista);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<User>updateUser(@RequestBody User user,@PathVariable("id")Long id){
		 User user2 = userService.actualizarUser(user, id);
		 
			if (user2 == null) {
				return ResponseEntity.notFound().build();
			}else {
				return ResponseEntity.ok(user2);
			}
	}
	
	@DeleteMapping("/borrar/{id}")
	public void borrarUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
	}
	
	
	


}
