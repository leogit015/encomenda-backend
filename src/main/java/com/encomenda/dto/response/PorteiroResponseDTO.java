package com.encomenda.dto.response;

import com.encomenda.infrastructure.entity.Porteiro;
import lombok.Data;

@Data
public class PorteiroResponseDTO {


    private Long id;
    private String nome;
    private String telefone;
    private String condominioNome;

    public PorteiroResponseDTO(Porteiro porteiro) {
        this.id = porteiro.getId();
        this.nome = porteiro.getNome();
        this.telefone = porteiro.getTelefone();
        this.condominioNome = porteiro.getCondominio().getNomeCondominio();
    }

}
