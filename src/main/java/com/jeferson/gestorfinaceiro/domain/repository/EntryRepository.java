package com.jeferson.gestorfinaceiro.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jeferson.gestorfinaceiro.domain.model.Category;
import com.jeferson.gestorfinaceiro.domain.model.Entry;
@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {

	
	
	public List<Entry> findByOrderById();
}
