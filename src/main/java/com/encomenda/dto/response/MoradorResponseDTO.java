package com.encomenda.dto.response;


import com.encomenda.infrastructure.entity.Morador;
import lombok.Getter;

@Getter
public class MoradorResponseDTO {

    private Long id;
    private String nome;
    private String telefone;
    private Integer bloco;
    private Integer apartamento;

    public MoradorResponseDTO(Morador morador){
        this.id = morador.getId();
        this.nome = morador.getNome();
        this.telefone = morador.getTelefone();
        this.bloco = morador.getBloco();
        this.apartamento = morador.getApartamento();

    }
}
