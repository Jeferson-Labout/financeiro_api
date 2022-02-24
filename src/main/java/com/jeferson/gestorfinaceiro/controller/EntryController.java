package com.jeferson.gestorfinaceiro.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Entry adicionar(@RequestBody Entry entry) {
		return entryService.salvar(entry);
	}
}
