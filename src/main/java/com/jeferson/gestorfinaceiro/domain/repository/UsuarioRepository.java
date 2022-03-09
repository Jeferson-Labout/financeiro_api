package com.jeferson.gestorfinaceiro.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeferson.gestorfinaceiro.domain.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
