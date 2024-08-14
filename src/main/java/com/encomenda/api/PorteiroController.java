package com.encomenda.api;



import com.encomenda.dto.request.PorteiroRequestDTO;
import com.encomenda.dto.response.PorteiroResponseDTO;
import com.encomenda.infrastructure.service.PorteiroService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/porteiros")
@RequiredArgsConstructor
public class PorteiroController {

    private final PorteiroService porteiroService;

    @GetMapping("/{id}")
    public ResponseEntity<PorteiroResponseDTO> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(porteiroService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<PorteiroResponseDTO>> findAll() {
        return ResponseEntity.ok().body(porteiroService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> register(@RequestBody PorteiroRequestDTO porteiroRequestDTO) {
        PorteiroResponseDTO newPorteiro = porteiroService.register(porteiroRequestDTO);
        return ResponseEntity.ok( "Porteiro criado com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<PorteiroResponseDTO> update(@RequestBody PorteiroRequestDTO porteiroDTO, @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(porteiroService.update(id, porteiroDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(porteiroService.delete(id));
    }
}

