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
    public ResponseEntity<PorteiroResponseDTO> register(@RequestBody PorteiroRequestDTO porteiroRequestDTO, UriComponentsBuilder uriBuilder) {
        PorteiroResponseDTO porteiroResponseDTO = porteiroService.register(porteiroRequestDTO);

        URI uri = uriBuilder.path("/porteiros/{id}").buildAndExpand(porteiroResponseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(porteiroResponseDTO);
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


