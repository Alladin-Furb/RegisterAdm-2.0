package com.transporte.escolar.service;

import com.transporte.escolar.model.Motorista;
import com.transporte.escolar.repository.MotoristaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MotoristaService {

    private final MotoristaRepository repository;

    public MotoristaService(MotoristaRepository repository) {
        this.repository = repository;
    }

    public List<Motorista> listar() {
        return repository.findAll();
    }

    public Motorista buscarPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Motorista não encontrado"));
    }

    public Motorista salvar(Motorista motorista) {
        return repository.save(motorista);
    }

    public Motorista atualizar(UUID id, Motorista dados) {

        Motorista motorista = buscarPorId(id);

        motorista.setNome(dados.getNome());
        motorista.setCarteiraMotorista(
                dados.getCarteiraMotorista());

        return repository.save(motorista);
    }

    public void remover(UUID id) {
        repository.deleteById(id);
    }
}