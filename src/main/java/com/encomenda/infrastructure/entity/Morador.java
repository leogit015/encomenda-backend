package com.encomenda.infrastructure.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity(name="morador")
@Table(name = "moradores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Morador  extends Pessoa{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "bloco", nullable = false)
    private Integer bloco;

    @Column(name = "apartamento", nullable = false)
    private Integer apartamento;

    @Builder

    public Morador( String nome, String telefone, Integer bloco, Integer apartamento) {
        super(nome,telefone);
        this.bloco = bloco;
        this.apartamento = apartamento;
    }
}
