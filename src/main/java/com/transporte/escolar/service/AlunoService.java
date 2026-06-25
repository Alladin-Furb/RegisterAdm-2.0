package com.transporte.escolar.service;

import com.transporte.escolar.config.AlunoEventProducer;
import com.transporte.escolar.model.Aluno;
import com.transporte.escolar.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AlunoService {

    private final AlunoRepository repository;
    private final AlunoEventProducer alunoEventProducer;

    public AlunoService(AlunoRepository repository, AlunoEventProducer alunoEventProducer) {
        this.repository = repository;
        this.alunoEventProducer = alunoEventProducer;
    }

    public List<Aluno> listar() {
        return repository.findAll();
    }

    public Aluno buscarPorId(UUID id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Aluno não encontrado"));
    }

    public Aluno salvar(Aluno aluno) {
        Aluno salvo = repository.save(aluno);
        alunoEventProducer.publicarAlunoCadastrado(salvo);
        return salvo;
    }

    public Aluno atualizar(UUID id, Aluno dados) {
        Aluno aluno = buscarPorId(id);

        aluno.setNome(dados.getNome());
        aluno.setMatricula(dados.getMatricula());
        aluno.setCpf(dados.getCpf());
        aluno.setTelefone(dados.getTelefone());
        aluno.setEndereco(dados.getEndereco());
        aluno.setEmail(dados.getEmail());
        aluno.setRotaTransporte(dados.getRotaTransporte());
        aluno.setCursoId(dados.getCursoId());
        aluno.setNomeCurso(dados.getNomeCurso());
        aluno.setFaculdade(dados.getFaculdade());
        aluno.setConfirmouPresenca(dados.isConfirmouPresenca());

        Aluno atualizado = repository.save(aluno);
        alunoEventProducer.publicarAlunoAtualizado(atualizado);
        return atualizado;
    }

    public void remover(UUID id) {
        repository.deleteById(id);
    }
}