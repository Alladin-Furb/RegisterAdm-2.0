package com.transporte.escolar.controller;

import com.transporte.escolar.model.Motorista;
import com.transporte.escolar.service.MotoristaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motoristas")
public class MotoristaController {

    private final MotoristaService service;

    public MotoristaController(MotoristaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Motorista> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Motorista buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Motorista criar(@RequestBody Motorista motorista) {
        return service.salvar(motorista);
    }

    @PutMapping("/{id}")
    public Motorista atualizar(@PathVariable Long id,
                               @RequestBody Motorista motorista) {
        return service.atualizar(id, motorista);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }
}