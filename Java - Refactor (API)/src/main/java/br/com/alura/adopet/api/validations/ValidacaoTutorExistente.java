package br.com.alura.adopet.api.validations;

import br.com.alura.adopet.api.dto.SolicitacaoCadastrarTutorDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.repository.TutorRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoTutorExistente implements ValidacaoSolicitacaoTutor {

    private final TutorRepository repository;

    public ValidacaoTutorExistente(TutorRepository repository) {
        this.repository = repository;
    }

    public void validar(SolicitacaoCadastrarTutorDTO dto) {
        boolean telefoneJaCadastrado = repository.existsByTelefone(dto.telefone());
        boolean emailJaCadastrado = repository.existsByEmail(dto.email());

        if (telefoneJaCadastrado || emailJaCadastrado) {
            throw new ValidacaoException("Dados já cadastrados para outro tutor!");
        }
    }
}
