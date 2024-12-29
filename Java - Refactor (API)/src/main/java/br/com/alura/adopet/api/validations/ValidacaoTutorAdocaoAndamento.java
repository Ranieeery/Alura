package br.com.alura.adopet.api.validations;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import br.com.alura.adopet.api.repository.TutorRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoTutorAdocaoAndamento implements ValidacaoSolicitacaoAdocao {

    private final AdocaoRepository adocaoRepository;

    private final TutorRepository tutorRepository;

    public ValidacaoTutorAdocaoAndamento(AdocaoRepository adocaoRepository, TutorRepository tutorRepository) {
        this.adocaoRepository = adocaoRepository;
        this.tutorRepository = tutorRepository;
    }

    public void validar(SolicitacaoAdocaoDTO dto) {
        boolean tutorAdocaoAndamento = tutorRepository.existsByTutorIdAndStatus(dto.idTutor(), StatusAdocao.AGUARDANDO_AVALIACAO);

        if (tutorAdocaoAndamento) {
            throw new ValidacaoException("Tutor já possui outra adoção aguardando avaliação!");

        }
    }
}
