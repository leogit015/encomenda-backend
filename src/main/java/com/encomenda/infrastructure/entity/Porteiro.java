package com.encomenda.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity (name ="porteiro")
@Table (name = "porteiros")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Porteiro extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Condom condominio;

    @Builder
    public Porteiro(String nome, String telefone, Long id, Condom condominio) {
        super(nome, telefone);
        this.id = id;
        this.condominio = condominio;
    }
}