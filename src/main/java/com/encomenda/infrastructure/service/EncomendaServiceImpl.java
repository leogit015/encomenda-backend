package com.encomenda.infrastructure.service;

import com.encomenda.dto.request.EncomendaRequestDTO;
import com.encomenda.dto.response.EncomendaResponseDTO;
import com.encomenda.exceptions.ResourceNotFoundException;
import com.encomenda.infrastructure.entity.Encomenda;
import com.encomenda.infrastructure.repository.EncomendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EncomendaServiceImpl implements EncomendaService{


   @Autowired
   private EncomendaRepository encomendaRepository;


    public Encomenda findById(Long id) {
        Optional<Encomenda> encomenda = encomendaRepository.findById(id);
        if (encomenda.isPresent()) {
            return encomenda.get();
        } else {
            throw new ResourceNotFoundException("Encomenda com ID " + id + " não encontrada.");
        }
    }

    @Override
    public List<EncomendaResponseDTO> findAll() {
        List<Encomenda> encomendas = encomendaRepository.findAll();
        return encomendas.stream()
                .map(EncomendaResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public EncomendaResponseDTO register(EncomendaRequestDTO encomendaDTO) {
        Encomenda encomenda = new Encomenda(encomendaDTO);
        Encomenda savedEncomenda = encomendaRepository.save(encomenda);
        return EncomendaResponseDTO.fromEntity(savedEncomenda);
    }

}
