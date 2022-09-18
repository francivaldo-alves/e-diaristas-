package com.f3pro.ediaristas.web.mappers;

import com.f3pro.ediaristas.core.models.Usuario;
import com.f3pro.ediaristas.web.dtos.UsuarioCadastroForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface WebUsuarioMapper {

    WebUsuarioMapper INSTANCE = Mappers.getMapper(WebUsuarioMapper.class);

    Usuario toModel (UsuarioCadastroForm form);
}
