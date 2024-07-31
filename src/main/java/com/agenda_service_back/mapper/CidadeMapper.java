package com.agenda_service_back.mapper;

import com.agenda_service_back.DTO.CidadeDTO;
import com.agenda_service_back.entity.Cidade;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CidadeMapper {
    //Conversor Entity(Model) para DTO
    @Mapping(source = "id", target = "id")
    CidadeDTO toDTO(Cidade cidade);

    @Mapping(source = "cidadeDTO.id", target="id")
    Cidade toEntity(CidadeDTO cidadeDTO);

    // recebendo uma lista de cidades do banco em DTO
    List<CidadeDTO> toDTO(List<Cidade> cidade);
    //trocar os dados de CidadeDTO para Cidade(entidade)
    @Mappings({
            @Mapping(source = "cidadeDTO.id", target = "id"),
            @Mapping(source = "cidadeDTO.nome", target = "nome"),
            @Mapping(source = "cidadeDTO.estado", target = "estado"),
            @Mapping(source = "cidadeDTO.enderecos", target = "enderecos")
    })
    Cidade updateEntity(CidadeDTO cidadeDTO, Cidade cidade);

}