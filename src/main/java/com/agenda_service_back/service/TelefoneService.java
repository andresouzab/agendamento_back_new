
package com.agenda_service_back.service;

import com.agenda_service_back.DTO.TelefoneDTO;
import com.agenda_service_back.entity.Telefone;
import com.agenda_service_back.mapper.TelefoneMapper;
import com.agenda_service_back.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TelefoneService {
    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private TelefoneMapper telefoneMapper;


    //buscar todas os telefones
    public List<TelefoneDTO> findAll(){
        List<Telefone> telefone =
                telefoneRepository.findAll();
        return telefone.stream()
                .map(telefoneMapper::toDTO)
                .collect(Collectors.toList());
    }
    //buscar um telefone pelo id
    public TelefoneDTO findById(Integer id){
        Telefone telefone = telefoneRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Telefone nâo encontrado"));
        return telefoneMapper.toDTO(telefone);
    }
    //criando um telefone
    public TelefoneDTO create(TelefoneDTO telefoneDTO){
        Telefone telefone = telefoneMapper.toEntity(telefoneDTO);
        telefone = telefoneRepository.save(telefone);
        return telefoneMapper.toDTO(telefone);
    }
    //update telefone
    public TelefoneDTO update(Integer id,TelefoneDTO telefoneDTO){
        Telefone telefone = telefoneRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Telefone não encontrado"));
        telefoneDTO.setId(id);
        telefone = telefoneMapper.updateEntity(telefoneDTO, telefone);
        telefone = telefoneRepository.save(telefone);
        return telefoneMapper.toDTO(telefone);
    }
    public void deleteById(Integer id){
        telefoneRepository.deleteById(id);
    }
}
