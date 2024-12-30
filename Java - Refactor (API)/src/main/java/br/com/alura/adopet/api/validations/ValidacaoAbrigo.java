package br.com.alura.adopet.api.validations;

import br.com.alura.adopet.api.model.Abrigo;

public interface ValidacaoAbrigo {
    public Abrigo validar(String idOuNome);
}
