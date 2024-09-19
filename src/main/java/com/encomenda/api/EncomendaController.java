package com.encomenda.api;

import com.encomenda.dto.request.EncomendaRequestDTO;
import com.encomenda.dto.response.EncomendaResponseDTO;
import com.encomenda.dto.response.PorteiroResponseDTO;
import com.encomenda.infrastructure.entity.Encomenda;
import com.encomenda.infrastructure.repository.EncomendaRepository;
import com.encomenda.infrastructure.service.EncomendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/encomendas")
@RequiredArgsConstructor
public class EncomendaController {

    @Autowired
    EncomendaRepository encomendaRepository;


    @Autowired
    EncomendaService encomendaService;

    @GetMapping("/{id}")
    public ResponseEntity<Encomenda> getEncomendaById(@PathVariable Long id) {
        Encomenda encomenda = encomendaService.findById(id);
        return ResponseEntity.ok(encomenda);
    }

    @GetMapping
    public List<EncomendaResponseDTO> findAll (){
        return encomendaService.findAll();
    }
    @PostMapping
    public ResponseEntity<String> register(@RequestBody EncomendaRequestDTO encomendaRequestDTO) {
        EncomendaResponseDTO newEncomenda = encomendaService.register(encomendaRequestDTO);

        return new ResponseEntity<>("Encomenda cadastrada com sucesso", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEncomendaById(@PathVariable Long id) {
        encomendaService.deleteById(id);
        return ResponseEntity.noContent().build(); // Retorna status 204 No Content
    }

}
