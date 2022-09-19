package com.f3pro.ediaristas.web.controller;

import com.f3pro.ediaristas.web.dtos.FlashMessage;
import com.f3pro.ediaristas.web.dtos.UsuarioCadastroForm;
import com.f3pro.ediaristas.web.services.WebUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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
        service.cadastrar(cadastroForm);
        attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Usuário cadastrado com sucesso!"));

        return "redirect:/admin/usuarios";
    }

    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id, RedirectAttributes attrs) {
        service.excluirPorId(id);
        attrs.addFlashAttribute("alert", new FlashMessage("alert-success", "Usuário excluído com sucesso!"));
        return "redirect:/admin/usuarios";
    }

}
