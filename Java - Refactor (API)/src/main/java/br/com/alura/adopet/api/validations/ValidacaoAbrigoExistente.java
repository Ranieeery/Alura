package br.com.alura.adopet.api.validations;

import br.com.alura.adopet.api.dto.CadastrarAbrigoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoAbrigoExistente implements ValidacaoSolicitacaoAbrigo {

    private final AbrigoRepository repository;

    public ValidacaoAbrigoExistente(AbrigoRepository repository) {
        this.repository = repository;
    }

    public void validar(CadastrarAbrigoDto dto) {
        boolean infosCadastradas = repository.existsByNomeOrTelefoneOrEmail(dto.nome(), dto.telefone(), dto.email());

        if (infosCadastradas) {
            throw new ValidacaoException("Dados já cadastrados para outro abrigo!");
        }
    }
}
