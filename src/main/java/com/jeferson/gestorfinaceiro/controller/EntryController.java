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

import com.jeferson.gestorfinaceiro.domain.model.Category;
import com.jeferson.gestorfinaceiro.domain.model.Entry;
import com.jeferson.gestorfinaceiro.domain.repository.EntryRepository;
import com.jeferson.gestorfinaceiro.domain.service.EntryService;

import lombok.AllArgsConstructor;
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/entry")
public class EntryController {

	private EntryService entryService;
	private EntryRepository entryRepository;
	
	@GetMapping
	public List<Entry> listar() {

		return entryRepository.findByOrderById();

	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Entry> buscar(@PathVariable Long id) {
		return entryRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entry adicionar(@RequestBody Entry entry) {
		return entryService.salvar(entry);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!entryRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		entryService.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Entry> atualizar(@PathVariable Long id, @Valid @RequestBody Entry entry) {
		if (!entryRepository.existsById(id)) {
			return ResponseEntity.notFound().build();

		}

		entry.setId(id);
		entry = entryService.salvar(entry);
		return ResponseEntity.ok(entry);
	}

}
