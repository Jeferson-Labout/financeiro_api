package com.jeferson.gestorfinaceiro.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jeferson.gestorfinaceiro.domain.model.Category;
import com.jeferson.gestorfinaceiro.domain.repository.CategoryRepository;
import com.jeferson.gestorfinaceiro.domain.service.CategoryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/category")
public class CategoryController {

	private CategoryRepository categoryRepository;
	private CategoryService categoryService;

	@GetMapping
	public List<Category> listar() {

		return categoryRepository.findByOrderById();

	}

	@GetMapping("/{id}")
	public ResponseEntity<Category> buscar(@PathVariable Long id) {
		return categoryRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Category adicionar(@Valid @RequestBody Category category) {
		return categoryService.salvar(category);

	}

	@PutMapping("/{id}")
	public ResponseEntity<Category> atualizar(@PathVariable Long id, @Valid @RequestBody Category category) {
		if (!categoryRepository.existsById(id)) {
			return ResponseEntity.notFound().build();

		}

		category.setId(id);
		category = categoryService.salvar(category);
		return ResponseEntity.ok(category);
	}

	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!categoryRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		categoryService.excluir(id);
		return ResponseEntity.noContent().build();
	}

}
