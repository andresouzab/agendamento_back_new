
package com.agenda_service_back.service;

import com.agenda_service_back.DTO.AgendamentoDTO;
import com.agenda_service_back.entity.Agendamento;
import com.agenda_service_back.mapper.AgendamentoMapper;
import com.agenda_service_back.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgendamentoService {
    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private AgendamentoMapper agendamentoMapper;


    //buscar todas os agendamentos
    public List<AgendamentoDTO> findAll(){
        List<Agendamento> agendamento =
                agendamentoRepository.findAll();
        return agendamento.stream()
                .map(agendamentoMapper::toDTO)
                .collect(Collectors.toList());
    }
    //buscar um agendamento pelo id
    public AgendamentoDTO findById(Integer id){
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Agendamento nâo encontrado"));
        return agendamentoMapper.toDTO(agendamento);
    }
    //criando um agendamento
    public AgendamentoDTO create(AgendamentoDTO agendamentoDTO){
        Agendamento agendamento = agendamentoMapper.toEntity(agendamentoDTO);
        agendamento = agendamentoRepository.save(agendamento);
        return agendamentoMapper.toDTO(agendamento);
    }
    //update agendamento
    public AgendamentoDTO update(Integer id,AgendamentoDTO agendamentoDTO){
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Agendamento não encontrado"));
        agendamentoDTO.setId(id);
        agendamento = agendamentoMapper.updateEntity(agendamentoDTO, agendamento);
        agendamento = agendamentoRepository.save(agendamento);
        return agendamentoMapper.toDTO(agendamento);
    }
    public void deleteById(Integer id){
        agendamentoRepository.deleteById(id);
    }
}
