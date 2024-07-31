
package com.agenda_service_back.service;

import com.agenda_service_back.DTO.ServicoDTO;
import com.agenda_service_back.entity.Servico;
import com.agenda_service_back.mapper.ServicoMapper;
import com.agenda_service_back.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private ServicoMapper servicoMapper;


    //buscar todas os servicos
    public List<ServicoDTO> findAll(){
        List<Servico> servico =
                servicoRepository.findAll();
        return servico.stream()
                .map(servicoMapper::toDTO)
                .collect(Collectors.toList());
    }
    //buscar um servico pelo id
    public ServicoDTO findById(Integer id){
        Servico servico = servicoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Serviço nâo encontrado"));
        return servicoMapper.toDTO(servico);
    }
    //criando um Servico
    public ServicoDTO create(ServicoDTO servicoDTO){
        Servico servico = servicoMapper.toEntity(servicoDTO);
        servico = servicoRepository.save(servico);
        return servicoMapper.toDTO(servico);
    }
    //update Servico
    public ServicoDTO update(Integer id,ServicoDTO servicoDTO){
        Servico servico = servicoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Serviço não encontrado"));
        servicoDTO.setId(id);
        servico = servicoMapper.updateEntity(servicoDTO, servico);
        servico = servicoRepository.save(servico);
        return servicoMapper.toDTO(servico);
    }
    public void deleteById(Integer id){
        servicoRepository.deleteById(id);
    }
}
