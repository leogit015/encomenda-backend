package com.encomenda.infrastructure.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity(name="morador")
@Table(name = "moradores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Morador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String nome;
    private Long telefone;
    private Integer bloco;
    private Integer apartamento;

    @Builder

    public Morador( String nome, Long telefone, Integer bloco, Integer apartamento) {
        this.nome = nome;
        this.telefone = telefone;
        this.bloco = bloco;
        this.apartamento = apartamento;
    }
}
