package br.com.alura.adopet.api.validations;

import br.com.alura.adopet.api.dto.SolicitacaoCadastrarAbrigoDTO;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoAbrigoExistente implements ValidacaoSolicitacaoAbrigo {

    private final AbrigoRepository repository;

    public ValidacaoAbrigoExistente(AbrigoRepository repository) {
        this.repository = repository;
    }

    public void validar(SolicitacaoCadastrarAbrigoDTO dto) {
        boolean nomeJaCadastrado = repository.existsByNome(dto.nome());
        boolean telefoneJaCadastrado = repository.existsByTelefone(dto.telefone());
        boolean emailJaCadastrado = repository.existsByEmail(dto.email());

        if (nomeJaCadastrado || telefoneJaCadastrado || emailJaCadastrado) {
            throw new ValidacaoException("Dados já cadastrados para outro abrigo!");
        }
    }
}
