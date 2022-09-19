package com.f3pro.ediaristas.web.services;

import com.f3pro.ediaristas.core.enums.TipoUsuario;
import com.f3pro.ediaristas.core.exceptions.UsuarioNaoEcontradoException;
import com.f3pro.ediaristas.core.models.Usuario;
import com.f3pro.ediaristas.core.repositories.UsuarioRepository;
import com.f3pro.ediaristas.web.dtos.UsuarioCadastroForm;
import com.f3pro.ediaristas.web.mappers.WebUsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebUsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private WebUsuarioMapper mapper;

    public List<Usuario> buscarTodos() {
        return repository.findAll();
    }

    public Usuario cadastrar(UsuarioCadastroForm form) {
        var model = mapper.toModel(form);
        model.setTipoUsuario(TipoUsuario.ADMIN);
        return repository.save(model);
    }

    public Usuario buscarPorId(Long id) {

        var mensagem = String.format("Servico com ID %d não encontrado", id);
    return repository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEcontradoException(mensagem));


    }

    public void excluirPorId(Long id){
        var usuario = buscarPorId(id);
        repository.delete(usuario);
    }


}
