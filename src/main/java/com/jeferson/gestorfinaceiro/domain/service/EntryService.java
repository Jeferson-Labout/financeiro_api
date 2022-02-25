package com.jeferson.gestorfinaceiro.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.jeferson.gestorfinaceiro.domain.exception.NegocioException;
import com.jeferson.gestorfinaceiro.domain.model.Category;
import com.jeferson.gestorfinaceiro.domain.model.Entry;
import com.jeferson.gestorfinaceiro.domain.repository.EntryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EntryService {
	
private EntryRepository entryRepository;
private CategoryService categoryService;

@Transactional
public Entry salvar(Entry entry) {
	Category category = categoryService.buscar(entry.getCategory().getId());
	entry.setCategory(category);
	return entryRepository.save(entry);
}

@Transactional
public Entry buscar(Long id) {
	return entryRepository.findById(id)
			.orElseThrow(()-> new NegocioException("Lançamento não encontrado"));
}

@Transactional
public void excluir(Long id) {
	entryRepository.deleteById(id);
}

}
