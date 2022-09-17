package com.f3pro.ediaristas.web.controller;

import com.f3pro.ediaristas.core.enums.Icone;
import com.f3pro.ediaristas.web.dtos.ServicoForm;
import com.f3pro.ediaristas.web.mappers.WebServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.f3pro.ediaristas.core.repositories.ServicoRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/servicos")
public class ServicoController {

    @Autowired
    private ServicoRepository repository;

    @Autowired
    private WebServiceMapper mapper;

    @GetMapping
    public ModelAndView buscarTodos() {
        var modelAndView = new ModelAndView("admin/servico/lista");
        modelAndView.addObject("servicos", repository.findAll());

        return modelAndView;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        var modelAndView = new ModelAndView("admin/servico/form");
        modelAndView.addObject("form", new ServicoForm());
        return modelAndView;
    }

    @PostMapping("/cadastrar")
    public String cadastrar(@Valid @ModelAttribute("form") ServicoForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/servico/form";
        }

        var servico = mapper.toModel(form);
        repository.save(servico);
        return "redirect:/admin/servicos";
    }

    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable Long id) {
        var modelAndView = new ModelAndView("admin/servico/form");
        var servico = repository.getById(id);
        var form = mapper.toForm(servico);
        modelAndView.addObject("form", form);
        return modelAndView;
    }

    @PostMapping("/{id}/editar")
    public String editar(@PathVariable long id, @Valid @ModelAttribute("form") ServicoForm form, BindingResult result) {
        if (result.hasErrors()) {
            return "admin/servico/form";
        }


        var servico = mapper.toModel(form);
        servico.setId(id);
        repository.save(servico);
        return "redirect:/admin/servicos";
    }

    @GetMapping("/{id}/excluir")
    public String exluir(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/admin/servicos";

    }

    @ModelAttribute("icones")
    public Icone[] getIcones() {
        return Icone.values();
    }
}