package com.example.escola.model;

import jakarta.persistence.Column;           // Define colunas no banco de dados
import jakarta.persistence.Entity;           // Define esta classe como uma entidade JPA
import jakarta.persistence.GeneratedValue;   // Define geração automática de IDs
import jakarta.persistence.GenerationType;   // Define a estratégia de geração de IDs
import jakarta.persistence.Id;               // Define o identificador (Primary Key) da entidade
import jakarta.persistence.Table;       // Executa lógica antes de salvar no banco de dados
import lombok.Getter;            // Define o nome da tabela no banco de dados
import lombok.NoArgsConstructor;                        // Lombok - Gera os métodos GET automaticamente
import lombok.Setter;             // Lombok - Gera um construtor sem argumentos

@Entity

@Table (name = "aluno")

@Getter
@Setter

@NoArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String email;
}
