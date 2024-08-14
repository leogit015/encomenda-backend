package com.encomenda.dto.response;

import com.encomenda.infrastructure.entity.Condom;
import lombok.Getter;

@Getter
public class CondomResponseDTO {

    private Long id;
    private String nome;
    private String rua;
    private Long numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String estado;

    public CondomResponseDTO(Condom condom){
        this.id = condom.getId();
        this.nome = condom.getNomeCondominio();
        this.rua = condom.getRua();
        this.numero = condom.getNumero();
        this.bairro = condom.getBairro();
        this.cep = condom.getCep();
        this.cidade = condom.getCidade();
        this.estado = condom.getEstado();
    }
}