package com.f3pro.ediaristas.web.dtos;

import com.f3pro.ediaristas.web.interfaces.IconfirmacaoSenha;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlterarSenhaForm  implements IconfirmacaoSenha {

    @NotNull
    @NotEmpty
    private String senhaAntiga;

    @NotNull
    @NotEmpty
    private String senha;

    @NotNull
    @NotEmpty
    private String confirmacaoSenha;
}
