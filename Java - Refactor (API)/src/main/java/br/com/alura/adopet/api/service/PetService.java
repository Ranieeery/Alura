package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.CadastrarPetDto;
import br.com.alura.adopet.api.dto.PetDto;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private final PetRepository repository;

    public PetService(PetRepository repository) {
        this.repository = repository;
    }

    public List<PetDto> listar() {
        return repository.findAllByAdotadoFalse().stream().map(PetDto::new).toList();
    }

    public void cadastroPet(Abrigo abrigo, CadastrarPetDto dto) {
        repository.save(new Pet(dto, abrigo));
    }
}
