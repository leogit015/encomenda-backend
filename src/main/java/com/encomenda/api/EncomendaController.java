package com.encomenda.api;

import com.encomenda.dto.response.EncomendaResponseDTO;
import com.encomenda.infrastructure.service.EncomendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/encomendas")
public class EncomendaController {

    @Autowired
    EncomendaService encomendaService;

    @GetMapping
    public List<EncomendaResponseDTO> findAll (){
        return encomendaService.findAll();
    }

}
