package com.encomenda.dto.response;

import com.encomenda.infrastructure.entity.Encomenda;

import java.time.LocalDateTime;

public record EncomendaResponseDTO(
        Long id,
        String descricao,
        LocalDateTime dataDeRecebimento,
        LocalDateTime dataDeEntrega,
        String porteiro,
        String morador
) {
    public static EncomendaResponseDTO fromEntity(Encomenda encomenda){
        return new EncomendaResponseDTO(
                encomenda.getId(),
                encomenda.getDescricao(),
                encomenda.getDataDeRecebimento(),
                encomenda.getDataDeEntrega(),
                encomenda.getPorteiro(),
                encomenda.getMorador()
        );
    }

}
