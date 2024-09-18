package com.encomenda.dto.request;



import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


public record EncomendaRequestDTO(
        Long id,
        String descricao,
        String morador,
        LocalDateTime dataDeRecebimento,
        LocalDateTime dataDeEntrega,
        String porteiro
) {
}
