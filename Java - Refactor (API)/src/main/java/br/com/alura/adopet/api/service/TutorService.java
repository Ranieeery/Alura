package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.AtualizarTutorDto;
import br.com.alura.adopet.api.dto.CadastrarTutorDto;
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

    public void cadastrar(CadastrarTutorDto dto) {
        validacoes.forEach(v -> v.validar(dto));

        Tutor tutor = new Tutor(dto.nome(), dto.telefone(), dto.email());

        repository.save(tutor);
    }

    public Tutor atualizar(AtualizarTutorDto dto) {
        Tutor tutor = repository.getReferenceById(dto.idTutor());
        tutor.atualizarTutor(dto);

        return tutor;
    }
}
