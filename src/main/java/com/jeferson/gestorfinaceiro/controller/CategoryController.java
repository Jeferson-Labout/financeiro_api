package com.jeferson.gestorfinaceiro.controller;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeferson.gestorfinaceiro.domain.model.Category;
@RestController
public class CategoryController {
	@PersistenceContext
	private EntityManager manager;
	@GetMapping("/category")
	public  List<Category> listar() {
		return manager.createQuery("from Category", Category.class)
				.getResultList();
		
	}

}
