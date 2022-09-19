package com.f3pro.ediaristas.core.exceptions;

import javax.persistence.EntityNotFoundException;

public class UsuarioNaoEcontradoException  extends EntityNotFoundException {

    public UsuarioNaoEcontradoException(String message) {
        super(message);
    }
}
