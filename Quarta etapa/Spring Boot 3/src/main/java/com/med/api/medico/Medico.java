package com.med.api.medico;


import com.med.api.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    private boolean ativo;

    public Medico(DadosCadMedico dadosMedico) {
        this.ativo = true;
        this.nome = dadosMedico.nome();
        this.email = dadosMedico.email();
        this.crm = dadosMedico.crm();
        this.telefone = dadosMedico.telefone();
        this.especialidade = dadosMedico.especialidade();
        this.endereco = new Endereco(dadosMedico.endereco());
    }

    public void atualizarInfo(DadosAttMedico dadosMedico) {
        if (dadosMedico.nome() != null) {
            this.nome = dadosMedico.nome();
        }
        if (dadosMedico.telefone() != null) {
            this.telefone = dadosMedico.telefone();
        }
        if (dadosMedico.endereco() != null) {
            this.endereco.atualizarInfo(dadosMedico.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
