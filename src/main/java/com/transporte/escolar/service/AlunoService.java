package com.transporte.escolar.service;

import com.transporte.escolar.model.Aluno;
import com.transporte.escolar.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    private final AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public List<Aluno> listar() {
        return repository.findAll();
    }

    public Aluno buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Aluno não encontrado"));
    }

    public Aluno salvar(Aluno aluno) {
        return repository.save(aluno);
    }

    public Aluno atualizar(Long id, Aluno dados) {

        Aluno aluno = buscarPorId(id);

        aluno.setNome(dados.getNome());
        aluno.setMatricula(dados.getMatricula());
        aluno.setTelefone(dados.getTelefone());
        aluno.setEndereco(dados.getEndereco());
        aluno.setConfirmouPresenca(dados.isConfirmouPresenca());

        return repository.save(aluno);
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}