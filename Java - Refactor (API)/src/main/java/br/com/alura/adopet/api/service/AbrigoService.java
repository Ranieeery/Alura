package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.AbrigoDto;
import br.com.alura.adopet.api.dto.CadastrarAbrigoDto;
import br.com.alura.adopet.api.dto.PetDto;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import br.com.alura.adopet.api.repository.PetRepository;
import br.com.alura.adopet.api.validations.ValidacaoAbrigoIdOuNome;
import br.com.alura.adopet.api.validations.ValidacaoSolicitacaoAbrigo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbrigoService {

    private final AbrigoRepository repository;

    private final PetRepository petRepository;

    private final List<ValidacaoSolicitacaoAbrigo> validacaoSolicitacaoAbrigos;

    private final List<ValidacaoAbrigoIdOuNome> validacaoAbrigoIdOuNomes;

    public AbrigoService(AbrigoRepository repository, PetRepository petRepository, List<ValidacaoSolicitacaoAbrigo> validacoes, List<ValidacaoAbrigoIdOuNome> validacaoAbrigoIdOuNomes) {
        this.repository = repository;
        this.petRepository = petRepository;
        this.validacaoSolicitacaoAbrigos = validacoes;
        this.validacaoAbrigoIdOuNomes = validacaoAbrigoIdOuNomes;
    }

    public void cadastrar(CadastrarAbrigoDto dto) {
        validacaoSolicitacaoAbrigos.forEach(v -> v.validar(dto));

        repository.save(new Abrigo(dto));
    }

    public List<AbrigoDto> listar() {
        return repository.findAll().stream().map(AbrigoDto::new).toList();
    }

    public List<PetDto> listarPets(String idOuNome) {
        Abrigo abrigo = carregarAbrigo(idOuNome);

        return petRepository.findByAbrigo(abrigo).stream().map(PetDto::new).toList();
    }

    public Abrigo carregarAbrigo(String idOuNome) {
        validacaoAbrigoIdOuNomes.forEach(v -> v.validar(idOuNome));

        return repository.findByNome(idOuNome).orElseThrow();
    }
}
