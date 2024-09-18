package com.encomenda.infrastructure.service;

import com.encomenda.dto.request.EncomendaRequestDTO;
import com.encomenda.dto.response.EncomendaResponseDTO;

import java.util.List;

public interface EncomendaService {

    List<EncomendaResponseDTO> findAll();

    EncomendaResponseDTO register(EncomendaRequestDTO encomendaDTO);
}
