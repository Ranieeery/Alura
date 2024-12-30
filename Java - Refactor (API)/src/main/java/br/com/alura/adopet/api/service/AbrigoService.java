package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.SolicitacaoCadastrarAbrigoDTO;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import br.com.alura.adopet.api.validations.ValidacaoSolicitacaoAbrigo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbrigoService {

    private final AbrigoRepository repository;

    private final List<ValidacaoSolicitacaoAbrigo> validacoes;

    public AbrigoService(AbrigoRepository repository, List<ValidacaoSolicitacaoAbrigo> validacoes) {
        this.repository = repository;
        this.validacoes = validacoes;
    }

    public void cadastrar(SolicitacaoCadastrarAbrigoDTO dto) {
        validacoes.forEach(v -> v.validar(dto));

        Abrigo abrigo = new Abrigo(dto.nome(), dto.telefone(), dto.email());

        repository.save(abrigo);
    }
}
