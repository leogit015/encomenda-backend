package com.encomenda.util;

import com.encomenda.dto.request.CondomRequestDTO;
import com.encomenda.dto.response.CondomResponseDTO;
import com.encomenda.infrastructure.entity.Condom;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CondomMapper {

    public Condom toCondom(CondomRequestDTO condomDTO) {

        return Condom.builder()
                .nome(condomDTO.getNome())
                .rua(condomDTO.getRua())
                .numero(condomDTO.getNumero())
                .bairro(condomDTO.getBairro())
                .cep(condomDTO.getCep())
                .cidade(condomDTO.getCidade())
                .estado(condomDTO.getEstado())
                .build();

    }

    public CondomResponseDTO toCondomDTO(Condom condom){
        return new CondomResponseDTO(condom);

    }

    public List<CondomResponseDTO> toCondominioDTO(List<Condom> condominioList){
        return condominioList.stream().map(CondomResponseDTO::new).collect(Collectors.toList());
    }

    public void updateCondomData(Condom condom, CondomRequestDTO condomDTO){
        condom.setNomeCondominio(condomDTO.getNome());
        condom.setRua(condomDTO.getRua());
        condom.setNumero(condomDTO.getNumero());
        condom.setBairro(condomDTO.getBairro());
        condom.setCep(condomDTO.getCep());
        condom.setCidade(condomDTO.getCidade());
        condom.setEstado(condomDTO.getEstado());
    }
}
