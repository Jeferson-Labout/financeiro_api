package com.jeferson.gestorfinaceiro.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jeferson.gestorfinaceiro.domain.exception.NegocioException;
import com.jeferson.gestorfinaceiro.domain.model.Category;
import com.jeferson.gestorfinaceiro.domain.repository.CategoryRepository;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class CategoryService {
	private CategoryRepository categoryRepository;
	
	@Transactional
	public Category salvar(Category category) {
		boolean nomeEmUso = categoryRepository.findByName(category.getName())
				.stream()
				.anyMatch(categoryExistente -> !categoryExistente.equals(category));

		if (nomeEmUso) {
			throw new NegocioException("Já existe um categoria cadastrado com este Nome.");
		}
		return categoryRepository.save(category);
	}
	
	@Transactional
	public void excluir(Long id) {
		categoryRepository.deleteById(id);
	}

}
