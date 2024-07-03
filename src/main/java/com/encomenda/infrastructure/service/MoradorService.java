package com.encomenda.infrastructure.service;


import com.encomenda.dto.request.MoradorRequestDTO;
import com.encomenda.dto.response.MoradorResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MoradorService {

    MoradorResponseDTO findById(Long id);

    List<MoradorResponseDTO> findAll();

    MoradorResponseDTO register(MoradorRequestDTO moradorDTO);

    MoradorResponseDTO update(Long id, MoradorRequestDTO moradorDTO);

    String delete(Long id);
}
