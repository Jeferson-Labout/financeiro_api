package com.jeferson.gestorfinaceiro.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jeferson.gestorfinaceiro.domain.model.Usuario;
import com.jeferson.gestorfinaceiro.domain.repository.UsuarioRepository;
import com.jeferson.gestorfinaceiro.domain.service.UsuarioService;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	

	private UsuarioService usuarioService;
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<Usuario> listar() {

		return usuarioRepository.findByOrderById();

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> buscar(@PathVariable Long id) {
		return usuarioRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario adicionar(@Valid @RequestBody Usuario usuario) {
		return usuarioService.salvar(usuario);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @Valid @RequestBody Usuario usuario) {
		if (!usuarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();

		}

		usuario.setId(id);
		usuario = usuarioService.salvar(usuario);
		return ResponseEntity.ok(usuario);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!usuarioRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		usuarioService.excluir(id);
		return ResponseEntity.noContent().build();
	}

	
}
