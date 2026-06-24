package com.transporte.escolar.service;

import com.transporte.escolar.model.Veiculo;
import com.transporte.escolar.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository) {
        this.repository = repository;
    }

    public List<Veiculo> listar() {
        return repository.findAll();
    }

    public Veiculo buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Veículo não encontrado"));
    }

    public Veiculo salvar(Veiculo veiculo) {
        if (veiculo.getCapacidade() <= 0) {
            throw new RuntimeException("Capacidade deve ser maior que zero");
        }
        return repository.save(veiculo);
    }

    public Veiculo atualizar(Long id, Veiculo dados) {
        Veiculo veiculo = buscarPorId(id);

        veiculo.setPlaca(dados.getPlaca());
        veiculo.setModelo(dados.getModelo());
        veiculo.setCapacidade(dados.getCapacidade());

        return repository.save(veiculo);
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}
