package com.med.api.domain.medico;

import com.med.api.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAttMedico(
        @NotNull
        Long id, String nome,
        String telefone,
        DadosEndereco endereco) {
}
