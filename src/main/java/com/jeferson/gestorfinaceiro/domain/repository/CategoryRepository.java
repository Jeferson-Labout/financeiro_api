package com.jeferson.gestorfinaceiro.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jeferson.gestorfinaceiro.domain.model.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	public List<Category> findByOrderById();
	
	Optional<Category> findByName(String name);
}
