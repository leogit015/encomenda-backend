package com.encomenda.dto.response;

import java.time.LocalDateTime;

public record EncomendaResponseDTO(
        Long id,
        String descricao,
        LocalDateTime dataDeRecebimento,
        LocalDateTime dataDeEntrega,
        String porteiro
) {
}
