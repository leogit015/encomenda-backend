package com.encomenda.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;



@Entity(name="condominio")
@Table (name = "condominios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Condom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private Long id;



    private String nome;
    private String rua;
    private Long numero;
    private String bairro;
    private String cep;
    private String cidade;

    @Builder
    public Condom(String nome, String rua, Long numero, String bairro, String cep, String cidade) {
        this.nome = nome;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
    }
}
