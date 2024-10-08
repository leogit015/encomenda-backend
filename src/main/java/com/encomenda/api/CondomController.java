package com.encomenda.api;

import com.encomenda.dto.request.CondomRequestDTO;
import com.encomenda.dto.response.CondomResponseDTO;
import com.encomenda.infrastructure.service.CondomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/condominios")
@RequiredArgsConstructor
public class CondomController {

    private final CondomService condomService;

    @GetMapping("/{id}")
    public ResponseEntity<CondomResponseDTO> findById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(condomService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<CondomResponseDTO>> findAll() {
        return ResponseEntity.ok().body(condomService.findAll());
    }

    @PostMapping
    public ResponseEntity<CondomResponseDTO> register(@RequestBody CondomRequestDTO condomRequestDTO, UriComponentsBuilder uriBuilder) {
        CondomResponseDTO condomResponseDTO = condomService.register(condomRequestDTO);

        URI uri = uriBuilder.path("/condominios/{id}").buildAndExpand(condomResponseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(condomResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CondomResponseDTO> update(@RequestBody CondomRequestDTO condomDTO, @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok().body(condomService.update(id, condomDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(condomService.delete(id));
    }
}
