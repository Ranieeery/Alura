package com.med.api.controller;

import com.med.api.domain.medico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    //CRUD - Create, Read, Update, Delete
    @Autowired
    private MedicoRepository repository;

    //Create
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadMedico dadosMedico, UriComponentsBuilder uriBuilder) {
        Medico medico = new Medico(dadosMedico);
        repository.save(medico);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhadosMedico(medico));
    }

    //Read
    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
        return ResponseEntity.ok(page);
    }
    //http://localhost:8080/medicos
    //?size=1 & page=4
    //?sort=nome ou ?sort=nome,asc
    //?sort=nome,desc

    //Update
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAttMedico dadosMedico) {
        var medico = repository.getReferenceById(dadosMedico.id());
        medico.atualizarInfo(dadosMedico);

        return ResponseEntity.ok(new DadosDetalhadosMedico(medico));
    }

    //Delete
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhadosMedico(medico));
    }
}
