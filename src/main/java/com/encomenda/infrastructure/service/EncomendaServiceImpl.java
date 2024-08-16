package com.encomenda.infrastructure.service;

import com.encomenda.dto.response.EncomendaResponseDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EncomendaServiceImpl implements EncomendaService{

    @Override
    public List<EncomendaResponseDTO> findAll() {
        var lista = new ArrayList<EncomendaResponseDTO>();
        var encomenda1 = new EncomendaResponseDTO(1L,"Livro", LocalDateTime.now(),LocalDateTime.now(),"Paulo");
        var encomenda2 = new EncomendaResponseDTO(2L,"Suplemento", LocalDateTime.now(),LocalDateTime.now(),"Paulo");
        lista.add(encomenda1);
        lista.add(encomenda2);
        return lista;
    }
}
