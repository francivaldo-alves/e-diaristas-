package com.f3pro.ediaristas.web.services;

import com.f3pro.ediaristas.core.enums.TipoUsuario;
import com.f3pro.ediaristas.core.exceptions.SenhasNaoConferemException;
import com.f3pro.ediaristas.core.exceptions.UsuarioJaCadastradoException;
import com.f3pro.ediaristas.core.exceptions.UsuarioNaoEcontradoException;
import com.f3pro.ediaristas.core.models.Usuario;
import com.f3pro.ediaristas.core.repositories.UsuarioRepository;
import com.f3pro.ediaristas.web.dtos.UsuarioCadastroForm;
import com.f3pro.ediaristas.web.dtos.UsuarioEdicaoForm;
import com.f3pro.ediaristas.web.mappers.WebUsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;

import java.util.List;

@Service
public class WebUsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private WebUsuarioMapper mapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Usuario> buscarTodos() {
        return repository.findAll();
    }

    public Usuario cadastrar(UsuarioCadastroForm form) {

        var senha = form.getSenha();
        var confirmacaoSenha = form.getConfirmacaoSenha();

        if (!senha.equals(confirmacaoSenha)) {
            var mensagem = "Os dois campos de senhas não conferem";
            var fieldError = new FieldError(form.getClass().getName(), "confirmacaoSenha", form.getConfirmacaoSenha(), false, null, null, mensagem);
            throw new SenhasNaoConferemException(mensagem, fieldError);
        }

        var model = mapper.toModel(form);
        var senhaHash = passwordEncoder.encode(model.getSenha());
        model.setSenha(senhaHash);

        model.setTipoUsuario(TipoUsuario.ADMIN);
        validarCampoUnico(model);
        return repository.save(model);
    }

    public Usuario buscarPorId(Long id) {

        var mensagem = String.format("Servico com ID %d não encontrado", id);
        return repository.findById(id)
                .orElseThrow(() -> new UsuarioNaoEcontradoException(mensagem));


    }

    public UsuarioEdicaoForm buscarFormPorId(Long id) {
        var usuario = buscarPorId(id);
        return mapper.toForm(usuario);
    }

    public Usuario editar(UsuarioEdicaoForm form, Long id) {

        var usuario = buscarPorId(id);
        var model = mapper.toModel(form);
        model.setId(usuario.getId());
        model.setSenha(usuario.getSenha());
        model.setTipoUsuario(usuario.getTipoUsuario());

        validarCampoUnico(model);
        return repository.save(model);

    }

    public void excluirPorId(Long id) {
        var usuario = buscarPorId(id);
        repository.delete(usuario);
    }

    private void validarCampoUnico(Usuario usuario) {
        repository.findByEmail(usuario.getEmail()).ifPresent((usuarioEncontrado) -> {
            if (!usuarioEncontrado.equals(usuario)) {
                var mensagem = "Já existe um usuário cadastrado com esse e-mail";
                var fieldError = new FieldError(usuario.getClass().getName(), "email", usuario.getEmail(), false, null, null, mensagem);
                throw new UsuarioJaCadastradoException(mensagem, fieldError);

            }
        });
    }

}
