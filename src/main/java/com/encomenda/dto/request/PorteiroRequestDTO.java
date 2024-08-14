package com.encomenda.dto.request;


import com.encomenda.api.CondomDeserializer;
import com.encomenda.infrastructure.entity.Condom;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PorteiroRequestDTO {

    @JsonDeserialize(using = CondomDeserializer.class)
    private String condominio;

    private String nome;
    private long  telefone;



}
