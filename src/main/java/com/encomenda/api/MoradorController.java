package com.encomenda.api;


import com.encomenda.dto.request.MoradorRequestDTO;
import com.encomenda.dto.response.MoradorResponseDTO;
import com.encomenda.infrastructure.service.MoradorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/{morador}")
@RequiredArgsConstructor
public class MoradorController {

    public  final MoradorService moradorService;


    @GetMapping(value ="/{id}")
    public ResponseEntity<MoradorResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(moradorService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<MoradorResponseDTO>> findAll() {
        return ResponseEntity.ok().body(moradorService.findAll());
    }

    @PostMapping
    public ResponseEntity<MoradorResponseDTO> register (@RequestBody MoradorRequestDTO moradorRequestDTO, UriComponentsBuilder uriBuilder){
        MoradorResponseDTO moradorResponseDTO = moradorService.register(moradorRequestDTO);

        URI uri = uriBuilder.path("/morador/{id}").buildAndExpand(moradorResponseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(moradorResponseDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MoradorResponseDTO> update (@RequestBody MoradorRequestDTO moradorDTO, @PathVariable(name = "id") Long id ) {
        return ResponseEntity.ok().body(moradorService.update(id,moradorDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(moradorService.delete(id));
    }

}



