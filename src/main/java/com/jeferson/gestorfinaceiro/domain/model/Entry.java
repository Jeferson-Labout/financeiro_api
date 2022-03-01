package com.jeferson.gestorfinaceiro.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true )
@Entity
public class Entry {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description ;	
	private String type ;
	private BigDecimal amount ;
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate date ;
	private boolean paid;
	@ManyToOne
	private Category category;
	@Column(name="category_id", updatable=false, insertable=false) 
    private Long categoryId;

}
