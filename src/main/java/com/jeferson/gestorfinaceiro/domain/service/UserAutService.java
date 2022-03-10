package com.jeferson.gestorfinaceiro.domain.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jeferson.gestorfinaceiro.domain.model.Usuario;
import com.jeferson.gestorfinaceiro.domain.repository.UsuarioRepository;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class UserAutService implements UserDetailsService{
	
	private UsuarioRepository usuarioRepository; 
	
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuario = usuarioRepository
				.findByName(name)
				.orElseThrow(()-> new UsernameNotFoundException("Login não encontrado.") );
		return User
				.builder()
				.username(usuario.getName())
				.password(usuario.getPassword())
				.roles("USER")
				.build();
	}
	
}
