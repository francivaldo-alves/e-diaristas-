package com.f3pro.ediaristas.auth.services;

import com.f3pro.ediaristas.auth.models.UsuarioAutenticado;
import com.f3pro.ediaristas.core.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        var mensagem = String.format("Usario com email %s não encontrado", email);
        return repository.findByEmail(email).map(UsuarioAutenticado::new)
                .orElseThrow(() -> new UsernameNotFoundException(mensagem));
    }
}