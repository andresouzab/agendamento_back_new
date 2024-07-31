
package com.agenda_service_back.service;

import com.agenda_service_back.DTO.CidadeDTO;
import com.agenda_service_back.entity.Cidade;
import com.agenda_service_back.mapper.CidadeMapper;
import com.agenda_service_back.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private CidadeMapper cidadeMapper;


    //buscar todas as cidades
    public List<CidadeDTO> findAll(){
        List<Cidade> cidade =
                cidadeRepository.findAll();
        return cidade.stream()
                .map(cidadeMapper::toDTO)
                .collect(Collectors.toList());
    }
    //buscar uma cidade pelo id
    public CidadeDTO findById(Integer id){
        Cidade cidade = cidadeRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Cidade nâo encontrada"));
        return cidadeMapper.toDTO(cidade);
    }
    //criando uma cidade
    public CidadeDTO create(CidadeDTO cidadeDTO){
        Cidade cidade = cidadeMapper.toEntity(cidadeDTO);
        cidade = cidadeRepository.save(cidade);
        return cidadeMapper.toDTO(cidade);
    }
    //update cidade
    public CidadeDTO update(Integer id, CidadeDTO cidadeDTO){
        Cidade cidade = cidadeRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Cidade não encontrada"));
        cidadeDTO.setId(id);
        cidade = cidadeMapper.updateEntity(cidadeDTO, cidade);
        cidade = cidadeRepository.save(cidade);
        return cidadeMapper.toDTO(cidade);
    }
    public void deleteById(Integer id){
        cidadeRepository.deleteById(id);
    }
}
