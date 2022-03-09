package com.jeferson.gestorfinaceiro.domain.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jeferson.gestorfinaceiro.domain.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public List<Usuario> findByOrderById();
	
	Optional<Usuario> findByName(String name);

}
