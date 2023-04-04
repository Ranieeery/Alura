package com.med.api.controller;

import com.med.api.medico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    //CRUD - Create, Read, Update, Delete
    @Autowired
    private MedicoRepository repository;

    //Create
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadMedico dadosMedico) {
        repository.save(new Medico(dadosMedico));
    }

    //Read
    @GetMapping
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }
    //http://localhost:8080/medicos
    //?size=1 & page=4
    //?sort=nome ou ?sort=nome,asc
    //?sort=nome,desc

    //Update
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAttMedico dadosMedico) {
        var medico = repository.getReferenceById(dadosMedico.id());
        medico.atualizarInfo(dadosMedico);
    }

    //Delete
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }
}
