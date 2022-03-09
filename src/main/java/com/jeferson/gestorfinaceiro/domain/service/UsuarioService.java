package com.jeferson.gestorfinaceiro.domain.service;
import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.jeferson.gestorfinaceiro.domain.exception.NegocioException;
import com.jeferson.gestorfinaceiro.domain.model.Usuario;
import com.jeferson.gestorfinaceiro.domain.repository.UsuarioRepository;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class UsuarioService implements UserDetailsService{
	
	private UsuarioRepository usuarioRepository; 
	

	
	public Usuario buscar(Long id) {
		return usuarioRepository.findById(id)
				.orElseThrow(()-> new NegocioException("Usuário não encontrado"));
	}
	
	@Transactional
	public Usuario salvar(Usuario usuario) {
		boolean nomeEmUso = usuarioRepository.findByName(usuario.getName())
				.stream()
				.anyMatch(usuarioExistente -> !usuarioExistente.equals(usuario));

		if (nomeEmUso) {
			throw new NegocioException("Já existe um Usuário cadastrado com este Nome.");
		}
		return usuarioRepository.save(usuario);
	}
	
	@Transactional
	public void excluir(Long id) {
		usuarioRepository.deleteById(id);
	}

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
