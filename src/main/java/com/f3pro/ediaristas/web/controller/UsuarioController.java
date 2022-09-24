package com.f3pro.ediaristas.web.controller;

import com.f3pro.ediaristas.core.exceptions.ValidacaoException;
import com.f3pro.ediaristas.web.dtos.AlterarSenhaForm;
import com.f3pro.ediaristas.web.dtos.FlashMessage;
import com.f3pro.ediaristas.web.dtos.UsuarioCadastroForm;
import com.f3pro.ediaristas.web.dtos.UsuarioEdicaoForm;
import com.f3pro.ediaristas.web.services.WebUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/admin/usuarios")
public class UsuarioController {
    @Autowired
    private WebUsuarioService service;

    @GetMapping
    public ModelAndView buscarTodos() {
        var modelAndView = new ModelAndView("admin/usuario/lista");
        modelAndView.addObject("usuarios", service.buscarTodos());

        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        var modelAndView = new ModelAndView("admin/usuario/cadastro-form");
        modelAndView.addObject("cadastroForm", new UsuarioCadastroForm());
        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public String cadastar(@Valid @ModelAttribute("cadastroForm") UsuarioCadastroForm cadastroForm, BindingResult result, RedirectAttributes attrs) {

        if (result.hasErrors()) {
            return "admin/usuario/cadastro-form";
        }

        try {

            service.cadastrar(cadastroForm);
            attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Usuário cadastrado com sucesso!"));
        } catch (ValidacaoException e) {
            result.addError(e.getFieldError());
            return "admin/usuario/cadastro-form";
        }

        return "redirect:/admin/usuarios";
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        var modelAndView = new ModelAndView("admin/usuario/edicao-form");
        modelAndView.addObject("edicaoForm", service.buscarFormPorId(id));
        return modelAndView;
    }

    @PostMapping("/{id}/editar")
    public String editar(@PathVariable Long id, @Valid @ModelAttribute("edicaoForm") UsuarioEdicaoForm edicaoForm, BindingResult result, RedirectAttributes attrs) {
        if (result.hasErrors()) {
            return "admin/usuario/edicao-form";

        }
        try {
            service.editar(edicaoForm, id);
            attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Usuário editado com sucesso!"));
        } catch (ValidacaoException e) {
            result.addError(e.getFieldError());
            return "admin/usuario/edicao-form";
        }

        return "redirect:/admin/usuarios";
    }


    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id, RedirectAttributes attrs) {
        service.excluirPorId(id);
        attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Usuário excluído com sucesso!"));
        return "redirect:/admin/usuarios";
    }

    @GetMapping("/alterar-senha")
    public ModelAndView alterarSenha() {
        var modelAndView = new ModelAndView("admin/usuario/alterar-senha");
        modelAndView.addObject("alterarSenhaForm", new AlterarSenhaForm());
        return modelAndView;
    }


    @PostMapping("/alterar-senha")
    public String alterarSenha(@Valid @ModelAttribute("alterarSenhaForm") AlterarSenhaForm alterarSenhaForm, BindingResult result, RedirectAttributes attrs, Principal principal) {
        if (result.hasErrors()) {
            return "admin/usuarios/alterar-senha";
        }
        try {
            service.alterarSenha(alterarSenhaForm, principal.getName());
            attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Senha Alterada com sucesso!"));
        } catch (ValidacaoException e) {
            result.addError(e.getFieldError());
            return "admin/usuarios/alterar-senha";
        }
        return "redirect:/admin/usuarios/alterar-senha";
    }
}
