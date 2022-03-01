package com.jeferson.gestorfinaceiro.domain.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Category {
@EqualsAndHashCode.Include	
@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@NotBlank
@Size(min=3, max = 60)
private String name;
@NotBlank
@Size(min=3, max = 60)
private String description;


}
