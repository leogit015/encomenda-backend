package com.encomenda.infrastructure.service;

import com.encomenda.dto.request.EncomendaRequestDTO;
import com.encomenda.dto.response.EncomendaResponseDTO;
import com.encomenda.infrastructure.entity.Encomenda;
import com.encomenda.infrastructure.repository.EncomendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EncomendaServiceImpl implements EncomendaService{

   /* @Override
    public List<EncomendaResponseDTO> findAll() {
        var lista = new ArrayList<EncomendaResponseDTO>();
        var encomenda1 = new EncomendaResponseDTO(1L,"Livro", LocalDateTime.now(),LocalDateTime.now(),"Paulo");
        var encomenda2 = new EncomendaResponseDTO(2L,"Suplemento", LocalDateTime.now(),LocalDateTime.now(),"Paulo");
        lista.add(encomenda1);
        lista.add(encomenda2);
        return null;
    }

    @Override
    public EncomendaResponseDTO register(EncomendaRequestDTO encomendaDTO) {

        return null;
    }*/
   @Autowired
   private EncomendaRepository encomendaRepository;

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
