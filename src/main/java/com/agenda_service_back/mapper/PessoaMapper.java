package com.agenda_service_back.mapper;

import com.agenda_service_back.DTO.PessoaDTO;
import com.agenda_service_back.entity.Pessoa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PessoaMapper {
    //Conversor Entity(Model) para DTO
    @Mapping(source = "id", target = "id")
    PessoaDTO toDTO(Pessoa pessoa);

    @Mapping(source = "pessoaDTO.id", target="id")
    Pessoa toEntity(PessoaDTO pessoaDTO);

    // recebendo uma lista de estados do banco em DTO
    List<PessoaDTO> toDTO(List<Pessoa> pessoa);
    //trocar os dados de PessoaDTO para Pessoa(entidade)
    @Mappings({
            @Mapping(source = "pessoaDTO.id", target = "id"),
            @Mapping(source = "pessoaDTO.nome", target = "nome"),
            @Mapping(source = "pessoaDTO.cpf", target = "cpf"),
            @Mapping(source = "pessoaDTO.data_nascimento", target = "data_nascimento"),
            @Mapping(source = "pessoaDTO.email", target = "email"),
            @Mapping(source = "pessoaDTO.senha", target = "senha"),
            @Mapping(source = "pessoaDTO.telefone", target = "telefone"),
            @Mapping(source = "pessoaDTO.endereco", target = "endereco"),
    })
    Pessoa updateEntity(PessoaDTO pessoaDTO, Pessoa pessoa);

}