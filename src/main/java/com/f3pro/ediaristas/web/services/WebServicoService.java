package com.f3pro.ediaristas.web.services;

import com.f3pro.ediaristas.core.exceptions.ServicoNaoEncontradoException;
import com.f3pro.ediaristas.core.models.Servico;
import com.f3pro.ediaristas.core.repositories.ServicoRepository;
import com.f3pro.ediaristas.web.dtos.ServicoForm;
import com.f3pro.ediaristas.web.mappers.WebServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebServicoService {

    @Autowired
    private ServicoRepository repository;

    @Autowired
    private WebServiceMapper mapper;


    public List<Servico> buscarTodos() {
        return repository.findAll();

    }

    public Servico cadastrar(ServicoForm form) {
        var model = mapper.toModel(form);
        return repository.save(model);

    }

    public Servico buscarPorId(Long id) {
        var servicoEncontrado = repository.findById(id);

        if (servicoEncontrado.isPresent()) {
            return servicoEncontrado.get();
        }
        var mensagem = String.format("Servico com ID %d não encontrado", id);
        throw new ServicoNaoEncontradoException(mensagem);

    }

    public Servico editar(ServicoForm form, Long id) {
        var servicoEncontrado = buscarPorId(id);

        var model = mapper.toModel(form);
        model.setId(servicoEncontrado.getId());
        return repository.save(model);
    }

    public void excluirPorId(Long id) {
        var servicoEncontrado = buscarPorId(id);
        repository.delete(servicoEncontrado);
    }

}
