package com.encomenda.infrastructure.service;


import com.encomenda.dto.request.MoradorRequestDTO;
import com.encomenda.dto.response.MoradorResponseDTO;
import com.encomenda.infrastructure.entity.Morador;
import com.encomenda.infrastructure.repository.MoradorRepository;
import com.encomenda.util.MoradorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class MoradorServiceImpl implements MoradorService {


    private final  MoradorRepository moradorRepository;

    private final MoradorMapper moradorMapper;


    @Override
    public MoradorResponseDTO findById(Long id){
        return moradorMapper.toMoradorDTO(returnMoradorEntity(id));
    }
    @Override
    public List<MoradorResponseDTO> findAll(){
        return moradorMapper.toMoradorDTO(moradorRepository.findAll()); //alterar para moradoresDTO
    }
    @Override
    public MoradorResponseDTO register(MoradorRequestDTO moradorDTO){
        Morador morador = moradorMapper.toMorador(moradorDTO);

        return moradorMapper.toMoradorDTO(moradorRepository.save(morador));
    }

    @Override
    public MoradorResponseDTO update( Long id, MoradorRequestDTO moradorDTO) {
    Morador morador = returnMoradorEntity(id);
        moradorMapper.updateMoradorData(morador,moradorDTO);
        return moradorMapper.toMoradorDTO(moradorRepository.save(morador));
    }

    @Override
    public String delete(Long id){
        moradorRepository.deleteById(id);
        return "Morador de id: " +id+ "deletado";
    }

    private Morador returnMoradorEntity(Long id) {
    return  moradorRepository.findById(id).orElseThrow (() -> new RuntimeException("O morador não foi encontrado no banco de dados"));
    }
}