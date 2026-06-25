package com.transporte.escolar.controller;

import com.transporte.escolar.model.Aluno;
import com.transporte.escolar.service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService service;

    public AlunoController(AlunoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Aluno> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Aluno buscarPorId(@PathVariable UUID id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Aluno criar(@RequestBody Aluno aluno) {
        return service.salvar(aluno);
    }

    @PutMapping("/{id}")
    public Aluno atualizar(@PathVariable UUID id,
                           @RequestBody Aluno aluno) {
        return service.atualizar(id, aluno);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable UUID id) {
        service.remover(id);
    }
}