package br.com.alura.adopet.api.validations;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import br.com.alura.adopet.api.repository.TutorRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoTutorComLimiteAdocoes implements ValidacaoSolicitacaoAdocao {

    private final AdocaoRepository adocaoRepository;

    private final TutorRepository tutorRepository;

    public ValidacaoTutorComLimiteAdocoes(AdocaoRepository adocaoRepository, TutorRepository tutorRepository) {
        this.adocaoRepository = adocaoRepository;
        this.tutorRepository = tutorRepository;
    }

    public void validar(SolicitacaoAdocaoDTO dto) {
        boolean tutorAdocaoAndamento = tutorRepository.existsByTutorIdAndStatus(dto.idTutor(), StatusAdocao.APROVADO);

        int contador = 0;

        if (tutorAdocaoAndamento) {
            contador = contador + 1;
        }

        if (contador == 5) {
            throw new ValidacaoException("Tutor chegou ao limite máximo de 5 adoções!");
        }
    }
}
