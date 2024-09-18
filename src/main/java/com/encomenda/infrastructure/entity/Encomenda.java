package com.encomenda.infrastructure.entity;

import com.encomenda.dto.request.EncomendaRequestDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@Data
public class Encomenda {

    public Encomenda() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "dataDeRecebimento", nullable = false)
    private LocalDateTime dataDeRecebimento;

    @Column(name = "dataDeEntrega", nullable = false)
    private LocalDateTime dataDeEntrega;

    @Column(name = "porteiro", nullable = false)
    private String porteiro;

    @Column(name = "morador", nullable = false)
    private String morador;

    @Builder

    public Encomenda(Long id, String descricao, LocalDateTime dataDeRecebimento, LocalDateTime dataDeEntrega, String porteiro, String morador) {
        this.id = id;
        this.descricao = descricao;
        this.dataDeRecebimento = dataDeRecebimento;
        this.dataDeEntrega = dataDeEntrega;
        this.porteiro = porteiro;
        this.morador = morador;
    }

   public Encomenda(EncomendaRequestDTO encomendaRequestDTO){
        this.descricao= encomendaRequestDTO.descricao();
        this.dataDeRecebimento = encomendaRequestDTO.dataDeRecebimento();
        this.dataDeEntrega = encomendaRequestDTO.dataDeEntrega();
        this.porteiro = encomendaRequestDTO.porteiro();
        this.morador = encomendaRequestDTO.morador();
    }

}



