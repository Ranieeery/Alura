package br.com.alura.adopet.api.validations;

import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ValidacaoAbrigoIdOuNome implements ValidacaoAbrigo {

    private final AbrigoRepository repository;

    public ValidacaoAbrigoIdOuNome(AbrigoRepository repository) {
        this.repository = repository;
    }

    public Abrigo validar(String idOuNome) {
        Optional<Abrigo> optional;
        try {
            Long id = Long.parseLong(idOuNome);
            optional = repository.findById(id);
        } catch (NumberFormatException exception) {
            optional = repository.findByNome(idOuNome);
        }

        return optional.orElseThrow(() -> new ValidacaoException("Abrigo não encontrado"));
    }
}
