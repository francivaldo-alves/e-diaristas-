package com.f3pro.ediaristas.web.mappers;

import com.f3pro.ediaristas.core.models.Servico;
import com.f3pro.ediaristas.web.dtos.ServicoForm;
import org.springframework.stereotype.Component;

@Component
public class WebServiceMapper {
    public Servico toModel(ServicoForm form) {
        if (form == null) {
            throw new IllegalArgumentException();
        }
        var model = new Servico();
        model.setNome(form.getNome());
        model.setValorMinimo(form.getValorMinimo());
        model.setQtdHoras(form.getQtdHoras());
        model.setProcentagemComissao(form.getProcentagemComissao());
        model.setHorasQuarto(form.getHorasQuarto());
        model.setValorQuarto(form.getValorQuarto());
        model.setHorasSala(form.getHorasSala());
        model.setValorSala(form.getValorSala());
        model.setHorasBanheiro(form.getHorasBanheiro());
        model.setValorBanheiro(form.getValorBanheiro());
        model.setValorCozinha(form.getValorCozinha());
        model.setHorasCozinha(form.getHorasCozinha());
        model.setHorasQuintal(form.getHorasQuintal());
        model.setValorQuintal(form.getValorQuintal());
        model.setHorasOutros(form.getHorasOutros());
        model.setValorOutros(form.getValorOutros());
        model.setIcone(form.getIcone());
        model.setPosicao(form.getPosicao());

        return model;

    }

    public ServicoForm toForm(Servico model) {
        if (model == null) {
            throw new IllegalArgumentException();
        }
        var form = new ServicoForm();


        form.setNome(model.getNome());
        form.setQtdHoras(model.getQtdHoras());
        form.setProcentagemComissao(model.getProcentagemComissao());
        form.setValorMinimo(model.getValorMinimo());
        form.setHorasQuarto(model.getHorasQuarto());
        form.setValorQuarto(model.getValorQuarto());
        form.setHorasSala(model.getHorasSala());
        form.setValorSala(model.getValorSala());
        form.setHorasBanheiro(model.getHorasBanheiro());
        form.setValorBanheiro(model.getValorBanheiro());
        form.setValorCozinha(model.getValorCozinha());
        form.setHorasCozinha(model.getHorasCozinha());
        form.setHorasQuintal(model.getHorasQuintal());
        form.setValorQuintal(model.getValorQuintal());
        form.setHorasOutros(model.getHorasOutros());
        form.setValorOutros(model.getValorOutros());
        form.setIcone(model.getIcone());
        form.setPosicao(model.getPosicao());

        return form;
    }


}
