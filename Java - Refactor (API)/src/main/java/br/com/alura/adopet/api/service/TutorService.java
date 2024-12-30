package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.SolicitacaoAtualizarTutorDTO;
import br.com.alura.adopet.api.dto.SolicitacaoCadastrarTutorDTO;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.TutorRepository;
import br.com.alura.adopet.api.validations.ValidacaoSolicitacaoTutor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {

    private final TutorRepository repository;

    private final List<ValidacaoSolicitacaoTutor> validacoes;

    public TutorService(TutorRepository repository, List<ValidacaoSolicitacaoTutor> validacoes) {
        this.repository = repository;
        this.validacoes = validacoes;
    }

    public void cadastrar(SolicitacaoCadastrarTutorDTO dto) {
        validacoes.forEach(v -> v.validar(dto));

        Tutor tutor = new Tutor(dto.nome(), dto.telefone(), dto.email());

        repository.save(tutor);
    }

    public Tutor atualizar(SolicitacaoAtualizarTutorDTO dto) {
        Tutor tutor = repository.getReferenceById(dto.idTutor());

        tutor.atualizarTutor(dto);

        return tutor;
    }
}
