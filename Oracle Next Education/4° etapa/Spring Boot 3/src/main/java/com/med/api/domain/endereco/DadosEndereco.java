package com.med.api.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank
        String logradouro,
        @NotBlank
        String estado,
        @NotBlank @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank
        String bairro,
        @NotBlank
        String cidade,
        String numero,
        String complemento
) {
}
