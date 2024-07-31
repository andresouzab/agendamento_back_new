package com.agenda_service_back.mapper;

import com.agenda_service_back.DTO.EstadoDTO;
import com.agenda_service_back.entity.Estado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstadoMapper {
    //Conversor Entity(Model) para DTO
    @Mapping(source = "id", target = "id")
    EstadoDTO toDTO(Estado estado);

    @Mapping(source = "estadoDTO.id", target="id")
    Estado toEntity(EstadoDTO estadoDTO);

    // recebendo uma lista de estados do banco em DTO
    List<EstadoDTO> toDTO(List<Estado> estado);
    //trocar os dados de EstadoDTO para Estado(entidade)
    @Mappings({
            @Mapping(source = "estadoDTO.id", target = "id"),
            @Mapping(source = "estadoDTO.nome", target = "nome"),
            @Mapping(source = "estadoDTO.uf", target = "uf"),
            @Mapping(source = "estadoDTO.cidades", target = "cidades")
    })
    Estado updateEntity(EstadoDTO estadoDTO, Estado estado);

}