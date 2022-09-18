package com.f3pro.ediaristas.web.mappers;

import com.f3pro.ediaristas.core.models.Servico;
import com.f3pro.ediaristas.web.dtos.ServicoForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface WebServiceMapper {

    WebServiceMapper INSTANCE = Mappers.getMapper(WebServiceMapper.class);

    Servico toModel(ServicoForm form);

    ServicoForm toForm(Servico model);


}
