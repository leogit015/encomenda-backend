package com.encomenda.dto.request;


import lombok.Getter;

@Getter
public class CondomRequestDTO {

    private String nome;
    private String rua;
    private Long numero;
    private String bairro;
    private String cep;
    private String cidade;
}
