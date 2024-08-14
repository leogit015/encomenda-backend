package com.encomenda.util;


import com.encomenda.dto.request.PorteiroRequestDTO;
import com.encomenda.dto.response.PorteiroResponseDTO;
import com.encomenda.infrastructure.entity.Condom;
import com.encomenda.infrastructure.entity.Porteiro;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PorteiroMapper {

    public Porteiro toPorteiro(PorteiroRequestDTO porteiroDTO) {
        return Porteiro.builder()
                .nome(porteiroDTO.getNome())
                .telefone(String.valueOf(porteiroDTO.getTelefone()))

                .build();
    }

    public PorteiroResponseDTO toPorteiroDTO(Porteiro porteiro) {
        return new PorteiroResponseDTO(porteiro);
    }

    public List<PorteiroResponseDTO> toPorteiroDTO(List<Porteiro> porteiroList) {
        return porteiroList.stream().map(PorteiroResponseDTO::new).collect(Collectors.toList());
    }

    public void updatePorteiroData(Porteiro porteiro, PorteiroRequestDTO porteiroDTO) {
        porteiro.setNome(porteiroDTO.getNome());
        porteiro.setTelefone(String.valueOf(porteiroDTO.getTelefone()));


    }
}
