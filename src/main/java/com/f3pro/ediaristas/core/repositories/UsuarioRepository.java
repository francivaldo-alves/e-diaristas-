package com.f3pro.ediaristas.core.repositories;

import com.f3pro.ediaristas.core.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
}
