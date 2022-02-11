package com.jeferson.gestorfinaceiro.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
private String name;
private String description;
}
