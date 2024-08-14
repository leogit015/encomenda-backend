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


    @Column(name = "nomeCondominio" , unique = true)
    private String nomeCondominio;

    @Column(name = "rua", nullable = false)
    private String rua;
    @Column(name = "numero", nullable = false)
    private Long numero;
    @Column(name = "bairro", nullable = false)
    private String bairro;
    @Column(name = "cep", nullable = false)
    private String cep;
    @Column(name = "cidade", nullable = false)
    private String cidade;
    @Column(name = "estado", nullable = false)
    private String estado;

    @Builder

    public Condom(String nome, Long id, String rua, Long numero, String bairro, String cep, String cidade, String estado) {
        this.nomeCondominio = nome;
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Condom(String nome) {
    }

    public Condom(String nomeCondominio, String bairro, String cep, String cidade, String estado, Long numero, String rua) {
    }
}
