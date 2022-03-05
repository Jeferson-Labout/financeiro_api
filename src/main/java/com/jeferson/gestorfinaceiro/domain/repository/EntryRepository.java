package com.jeferson.gestorfinaceiro.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jeferson.gestorfinaceiro.domain.model.Entry;
@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {

	
	
	public List<Entry> findByOrderByDate();
	
	@Query(value = "SELECT * FROM entry WHERE Extract(month from date ) = :eventDateMonth and Extract(year from date ) = :eventDateYear order by  date", nativeQuery = true)
	List<Entry> buscaMes(@Param("eventDateMonth") Integer eventDateMonth, @Param("eventDateYear") Integer eventDateYear);

}
