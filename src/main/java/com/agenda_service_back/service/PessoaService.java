
package com.agenda_service_back.service;

import com.agenda_service_back.DTO.PessoaDTO;
import com.agenda_service_back.entity.Pessoa;
import com.agenda_service_back.mapper.PessoaMapper;
import com.agenda_service_back.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaMapper pessoaMapper;


    //buscar todas as pessoas
    public List<PessoaDTO> findAll(){
        List<Pessoa> pessoa =
                pessoaRepository.findAll();
        System.out.println(pessoa);
        return pessoa.stream()
                .map(pessoaMapper::toDTO)
                .collect(Collectors.toList());
    }
    //buscar um pessoa pelo id
    public PessoaDTO findById(Integer id){
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Pessoa nâo encontrado"));
        return pessoaMapper.toDTO(pessoa);
    }
    //criando uma pessoa
    public PessoaDTO create(PessoaDTO pessoaDTO){
        Pessoa pessoa = pessoaMapper.toEntity(pessoaDTO);
        pessoa = pessoaRepository.save(pessoa);
        return pessoaMapper.toDTO(pessoa);
    }
    //update pessoa
    public PessoaDTO update(Integer id,PessoaDTO pessoaDTO){
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Pessoa não encontrado"));
        pessoaDTO.setId(id);
        pessoa = pessoaMapper.updateEntity(pessoaDTO, pessoa);
        pessoa = pessoaRepository.save(pessoa);
        return pessoaMapper.toDTO(pessoa);
    }
    public void deleteById(Integer id){
        pessoaRepository.deleteById(id);
    }


    public Pessoa findByEmail(String email) {
        return pessoaRepository.findByEmail(email);
    }
}
