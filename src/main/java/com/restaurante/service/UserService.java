package com.restaurante.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.entity.User;
import com.restaurante.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	//Guardar
	public User saveUser(User user) {
		
		return userRepository.save(user);
	}
	
	//BuscarUSuario
	public User buscarUsuario(String email, String  contrasena) {
		return userRepository.usuarioContrasena(email, contrasena);
	}
	
	
	//buscar usuario
	public User buscarUser(Long userId) {
		User user = userRepository.findById(userId).orElse(null);
		
		return user;
	}
	
	public List<User>ListaUsuarios(){
		return userRepository.findAll();
	}
	
	
	//Actualizar
	public User actualizarUser(User user ,Long id) {
		User user2 = new User();
		user2 = userRepository.findById(id).orElse(null);
		
		if (user2== null) {
			return null;
			
		}else {
			user2.setNombre(user.getNombre());
			user2.setEmail(user.getEmail());
			user2.setContrasena(user.getContrasena());
			return userRepository.save(user2);
		}
		
	}
	
	//Borrar
	public void deleteUser(Long id) {
		User user = userRepository.findById(id).orElse(null);
		
		userRepository.delete(user);
	}
	

}
