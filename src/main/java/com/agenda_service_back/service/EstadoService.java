
package com.agenda_service_back.service;

import com.agenda_service_back.DTO.EstadoDTO;
import com.agenda_service_back.entity.Estado;
import com.agenda_service_back.mapper.EstadoMapper;
import com.agenda_service_back.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private EstadoMapper estadoMapper;


    //buscar todas os estados
    public List<EstadoDTO> findAll(){
        List<Estado> estado =
                estadoRepository.findAll();
        System.out.println(estado);
        return estado.stream()
                .map(estadoMapper::toDTO)
                .collect(Collectors.toList());
    }
    //buscar um estado pelo id
    public EstadoDTO findById(Integer id){
        Estado estado = estadoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Estado nâo encontrado"));
        return estadoMapper.toDTO(estado);
    }
    //criando um endereco
    public EstadoDTO create(EstadoDTO estadoDTO){
        Estado estado = estadoMapper.toEntity(estadoDTO);
        estado = estadoRepository.save(estado);
        return estadoMapper.toDTO(estado);
    }
    //update endereco
    public EstadoDTO update(Integer id,EstadoDTO estadoDTO){
        Estado estado = estadoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Estado não encontrado"));
        estadoDTO.setId(id);
        estado = estadoMapper.updateEntity(estadoDTO, estado);
        estado = estadoRepository.save(estado);
        return estadoMapper.toDTO(estado);
    }
    public void deleteById(Integer id){
        estadoRepository.deleteById(id);
    }
}
