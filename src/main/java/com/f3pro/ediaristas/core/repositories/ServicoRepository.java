package com.f3pro.ediaristas.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.f3pro.ediaristas.core.models.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
    
}
