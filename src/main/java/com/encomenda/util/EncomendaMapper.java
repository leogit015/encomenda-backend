package com.encomenda.util;

import com.encomenda.dto.request.EncomendaRequestDTO;
import com.encomenda.dto.response.EncomendaResponseDTO;
import com.encomenda.infrastructure.entity.Encomenda;
import org.springframework.stereotype.Component;



@Component
public class EncomendaMapper {

    public Encomenda toEncomenda(EncomendaRequestDTO encomendaRequestDTO) {

        return new Encomenda(encomendaRequestDTO);
    }

}
