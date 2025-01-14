package br.com.alura.adopet.api.controller;

import br.com.alura.adopet.api.dto.AtualizarTutorDto;
import br.com.alura.adopet.api.dto.CadastrarTutorDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
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

    private final TutorService service;

    public TutorController(TutorRepository repository, TutorService service) {
        this.service = service;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> cadastrar(@RequestBody @Valid CadastrarTutorDto tutor) {
        try {
            this.service.cadastrar(tutor);
            return ResponseEntity.ok().build();
        } catch (ValidacaoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity<AtualizarTutorDto> atualizar(@RequestBody @Valid AtualizarTutorDto dto) {
        Tutor tutor = this.service.atualizar(dto);

        return ResponseEntity.ok(new AtualizarTutorDto(tutor));
    }

}
