package com.encomenda.infrastructure.service;

import com.encomenda.dto.request.CondomRequestDTO;
import com.encomenda.dto.response.CondomResponseDTO;
import com.encomenda.infrastructure.entity.Condom;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CondomService {

    CondomResponseDTO findById(Long id);

    List<CondomResponseDTO> findAll();

    CondomResponseDTO register(CondomRequestDTO condomDTO);

    CondomResponseDTO update(Long id, CondomRequestDTO condomDTO);

    String delete(Long id);

    Condom getCondomByName(String condominioNome);

}


