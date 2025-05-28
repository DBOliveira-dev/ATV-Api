package com.example.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.escola.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
