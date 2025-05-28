package com.example.escola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.escola.model.Aluno;
import com.example.escola.servicer.AlunoService;

// Define a classe como um controller REST
@RestController
@RequestMapping("/api/alunos") // Caminho base da API
public class AlunoController {

    @Autowired
    private AlunoService service;

    // GET: Lista todos os alunos
    @GetMapping
    public List<Aluno> listarTodos() {
        return service.listarTodos();
    }

    // GET: Busca um aluno pelo ID
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST: Cadastra um novo aluno
    @PostMapping
    public Aluno cadastrar(@RequestBody Aluno aluno) {
        return service.salvar(aluno);
    }

    // PUT: Atualiza os dados de um aluno
    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno aluno) {
        if (!service.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        aluno.setId(id);
        return ResponseEntity.ok(service.salvar(aluno));
    }

    // DELETE: Remove um aluno pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!service.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
