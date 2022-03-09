package com.jeferson.gestorfinaceiro.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Usuario {
	
@EqualsAndHashCode.Include	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@NotBlank
@Column(unique=true)
private String name;
@NotBlank
@Column(unique=false)
private String password;
}