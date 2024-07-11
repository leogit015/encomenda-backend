package com.encomenda.infrastructure.service;

import com.encomenda.dto.request.PorteiroRequestDTO;
import com.encomenda.dto.response.PorteiroResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PorteiroService {

    PorteiroResponseDTO findById(Long id);

    List<PorteiroResponseDTO> findAll();

    PorteiroResponseDTO register(PorteiroRequestDTO porteiroDTO);

    PorteiroResponseDTO update(Long id, PorteiroRequestDTO porteiroDTO);

    String delete(Long id);


}
