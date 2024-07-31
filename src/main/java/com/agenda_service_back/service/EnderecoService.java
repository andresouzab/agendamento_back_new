
package com.agenda_service_back.service;

import com.agenda_service_back.DTO.EnderecoDTO;
import com.agenda_service_back.entity.Endereco;
import com.agenda_service_back.mapper.EnderecoMapper;
import com.agenda_service_back.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EnderecoMapper enderecoMapper;


    //buscar todas os enderecos
    public List<EnderecoDTO> findAll(){
        List<Endereco> endereco =
                enderecoRepository.findAll();
        return endereco.stream()
                .map(enderecoMapper::toDTO)
                .collect(Collectors.toList());
    }
    //buscar um endereco pelo id
    public EnderecoDTO findById(Integer id){
        Endereco endereco = enderecoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Endereço nâo encontrado"));
        return enderecoMapper.toDTO(endereco);
    }
    //criando um endereco
    public EnderecoDTO create(EnderecoDTO enderecoDTO){
        //TODO: BUSCAR PRIMEIRO PELO enderecoDTO.rua antes e caso encontre, retorne.
        Endereco endereco = enderecoMapper.toEntity(enderecoDTO);
        endereco = enderecoRepository.save(endereco);
        return enderecoMapper.toDTO(endereco);
    }
    //update endereco
    public EnderecoDTO update(Integer id,EnderecoDTO enderecoDTO){
        Endereco endereco = enderecoRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Endereço não encontrado"));
        enderecoDTO.setId(id);
        endereco = enderecoMapper.updateEntity(enderecoDTO, endereco);
        endereco = enderecoRepository.save(endereco);
        return enderecoMapper.toDTO(endereco);
    }
    public void deleteById(Integer id){
        enderecoRepository.deleteById(id);
    }
}
