package com.encomenda.infrastructure.service;

import com.encomenda.dto.request.EncomendaRequestDTO;
import com.encomenda.dto.response.EncomendaResponseDTO;
import com.encomenda.infrastructure.entity.Encomenda;

import java.util.List;

public interface EncomendaService {

    Encomenda findById (Long id);

    List<EncomendaResponseDTO> findAll();

    EncomendaResponseDTO register(EncomendaRequestDTO encomendaDTO);
}
