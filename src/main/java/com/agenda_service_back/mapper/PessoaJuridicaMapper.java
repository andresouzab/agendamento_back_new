package com.agenda_service_back.mapper;

import com.agenda_service_back.DTO.PessoaJuridicaDTO;
import com.agenda_service_back.entity.PessoaJuridica;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PessoaJuridicaMapper {
    //Conversor Entity(Model) para DTO
    @Mapping(source = "id", target = "id")
    PessoaJuridicaDTO toDTO(PessoaJuridica pessoaJuridica);

    @Mapping(source = "pessoaJuridicaDTO.id", target="id")
    PessoaJuridica toEntity(PessoaJuridicaDTO pessoaJuridicaDTO);

    // recebendo uma lista de pessoas Juridicas do banco em DTO
    List<PessoaJuridicaDTO> toDTO(List<PessoaJuridica> pessoaJuridica);
    //trocar os dados de PessoaJuridicaDTO para PessoaJuridica(entidade)
    @Mappings({
            @Mapping(source = "pessoaJuridicaDTO.id", target = "id"),
            @Mapping(source = "pessoaJuridicaDTO.nome", target = "nome"),
            @Mapping(source = "pessoaJuridicaDTO.cnpj", target = "cnpj"),
            @Mapping(source = "pessoaJuridicaDTO.razao_social", target = "razao_social"),
            @Mapping(source = "pessoaJuridicaDTO.email", target = "email"),
            @Mapping(source = "pessoaJuridicaDTO.senha", target = "senha"),
            @Mapping(source = "pessoaJuridicaDTO.telefone", target = "telefone"),
            @Mapping(source = "pessoaJuridicaDTO.endereco", target = "endereco"),
            @Mapping(source = "pessoaJuridicaDTO.servico", target = "servico"),
    })
    PessoaJuridica updateEntity(PessoaJuridicaDTO pessoaJuridicaDTO, PessoaJuridica pessoaJuridica);

}