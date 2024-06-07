package com.encomenda.infrastructure.service;

import com.encomenda.dto.request.CondomRequestDTO;
import com.encomenda.dto.response.CondomResponseDTO;
import com.encomenda.infrastructure.entity.Condom;
import com.encomenda.infrastructure.repository.CondomRepository;
import com.encomenda.util.CondomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Primary
@RequiredArgsConstructor
public class CondomServiceImpl implements CondomService {

    private final CondomRepository condomRepository;

    private final CondomMapper condomMapper;

    @Override
    public CondomResponseDTO findById(Long id) {
       return condomMapper.toCondomDTO(returnCondominioEntity(id));
    }

    @Override
    public List<CondomResponseDTO> findAll() {
        return condomMapper.toCondominioDTO(condomRepository.findAll());
    }

    @Override
    public CondomResponseDTO register(CondomRequestDTO condomDTO) {
        Condom condom = condomMapper.toCondom(condomDTO);

        return condomMapper.toCondomDTO(condomRepository.save(condom));
    }

    @Override
    public CondomResponseDTO update( Long id, CondomRequestDTO condomDTO) {
        Condom condom = returnCondominioEntity(id);
        condomMapper.updateCondomData(condom,condomDTO);
        return condomMapper.toCondomDTO(condomRepository.save(condom));
    }

    @Override
    public String delete(Long id) {
        condomRepository.deleteById(id);
        return "Condominio de id: " +id+ "deletado";
    }

    private Condom returnCondominioEntity(Long id) {
        return  condomRepository.findById(id).orElseThrow (() -> new RuntimeException("O condominio não foi encontrado no banco de dados"));
    }
}
