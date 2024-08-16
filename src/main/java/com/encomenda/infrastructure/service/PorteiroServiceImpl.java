package com.encomenda.infrastructure.service;

import com.encomenda.dto.request.PorteiroRequestDTO;
import com.encomenda.dto.response.PorteiroResponseDTO;
import com.encomenda.infrastructure.entity.Condom;
import com.encomenda.infrastructure.entity.Porteiro;
import com.encomenda.infrastructure.repository.CondomRepository;
import com.encomenda.infrastructure.repository.PorteiroRepository;
import com.encomenda.util.PorteiroMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PorteiroServiceImpl implements PorteiroService {

    private final PorteiroRepository porteiroRepository;
    private final PorteiroMapper porteiroMapper;


    @Autowired
    private CondomService condomService;

    @Override
    public PorteiroResponseDTO findById(Long id) {
        return porteiroMapper.toPorteiroDTO(returnPorteiroEntity(id));
    }

    @Override
    public List<PorteiroResponseDTO> findAll() {
        List<Porteiro> porteiroList = porteiroRepository.findAll();
        return porteiroMapper.toPorteiroDTO(porteiroList);
    }

    @Override
    public PorteiroResponseDTO register(PorteiroRequestDTO porteiroDTO) {
        // Mapeia o DTO para a entidade Porteiro
        Porteiro porteiro = porteiroMapper.toPorteiro(porteiroDTO);

        // Busca pelo condomínio pelo nome

        Condom condom = condomService.getCondomByName(porteiroDTO.getCondominio());
        porteiro.setCondominio(condom);


        Porteiro savedPorteiro = porteiroRepository.save(porteiro);
        return porteiroMapper.toPorteiroDTO(savedPorteiro);
    }


    @Override
    public PorteiroResponseDTO update(Long id, PorteiroRequestDTO porteiroDTO) {
        Porteiro porteiro = returnPorteiroEntity(id);
        porteiroMapper.updatePorteiroData(porteiro, porteiroDTO);
        Condom condom = condomService.getCondomByName(porteiroDTO.getCondominio());
        porteiro.setCondominio(condom);
        Porteiro updatedPorteiro = porteiroRepository.save(porteiro);
        return porteiroMapper.toPorteiroDTO(updatedPorteiro);
    }

    @Override
    public String delete(Long id) {
        porteiroRepository.deleteById(id);
        return "Porteiro de ID " + id + " deletado com sucesso";
    }

    private Porteiro returnPorteiroEntity(Long id) {
        return porteiroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Porteiro não encontrado com o ID: " + id));
    }
}