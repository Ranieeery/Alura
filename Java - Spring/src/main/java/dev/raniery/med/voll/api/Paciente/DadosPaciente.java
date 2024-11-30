package dev.raniery.med.voll.api.Paciente;

import dev.raniery.med.voll.api.dados.Endereco;

public record DadosPaciente(
    Long id,
    String nome,
    String email,
    String cpf,
    Endereco endereco) {

    public DadosPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getEndereco());
    }
}
