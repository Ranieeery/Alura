package br.com.alura.adopet.api.controller;

import br.com.alura.adopet.api.dto.SolicitacaoCadastrarTutorDTO;
import br.com.alura.adopet.api.model.Tutor;
import br.com.alura.adopet.api.repository.TutorRepository;
import br.com.alura.adopet.api.service.TutorService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    private final TutorRepository repository;

    private final TutorService service;

    public TutorController(TutorRepository repository, TutorService service) {
        this.repository = repository;
        this.service = service;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid SolicitacaoCadastrarTutorDTO tutor) {
        this.service.cadastro(tutor);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity<String> atualizar(@RequestBody @Valid Tutor tutor) {
        repository.save(tutor);
        return ResponseEntity.ok().build();
    }

}
