package br.com.alura.adopet.api.dto;

import br.com.alura.adopet.api.model.Tutor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record SolicitacaoAtualizarTutorDTO(

    @NotNull
    Long idTutor,

    String nome,

    @Pattern(regexp = "\\(?\\d{2}\\)?\\d?\\d{4}-?\\d{4}")
    String telefone,

    @Email
    String email) {

    public SolicitacaoAtualizarTutorDTO(Tutor tutor){
        this(tutor.getId(), tutor.getNome(), tutor.getTelefone(), tutor.getEmail());
    }
}
