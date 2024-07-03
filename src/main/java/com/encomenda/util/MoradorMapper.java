package com.encomenda.util;


import com.encomenda.dto.request.MoradorRequestDTO;
import com.encomenda.dto.response.MoradorResponseDTO;
import com.encomenda.infrastructure.entity.Morador;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MoradorMapper {

    public Morador toMorador(MoradorRequestDTO moradorDTO){
        return Morador.builder()
                .nome(moradorDTO.getNome())
                .telefone(moradorDTO.getTelefone())
                .bloco(moradorDTO.getBloco())
                .apartamento(moradorDTO.getApartamento())
                .build();
    }
    public MoradorResponseDTO toMoradorDTO(Morador morador){
        return new MoradorResponseDTO(morador);
    }

    public List<MoradorResponseDTO> toMoradorDTO(List<Morador> moradorList){
        return moradorList.stream().map(MoradorResponseDTO::new).collect(Collectors.toList());
    }

    public void updateMoradorData(Morador morador, MoradorRequestDTO moradorDTO){
        morador.setNome(moradorDTO.getNome());
        morador.setTelefone(moradorDTO.getTelefone());
        morador.setBloco(moradorDTO.getBloco());
        morador.setApartamento(moradorDTO.getApartamento());
    }
}
