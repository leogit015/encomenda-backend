package com.encomenda.dto.request;


import com.encomenda.infrastructure.entity.Condom;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PorteiroRequestDTO {

    private String nome;
    private String telefone;
    private Condom condominio;


}
