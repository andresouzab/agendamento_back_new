package com.agenda_service_back.mapper;

import com.agenda_service_back.DTO.AgendamentoDTO;
import com.agenda_service_back.entity.Agendamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgendamentoMapper {
    //Conversor Entity(Model) para DTO
    @Mapping(source = "id", target = "id")
    AgendamentoDTO toDTO(Agendamento agendamento);

    @Mapping(source = "agendamentoDTO.id", target="id")
    Agendamento toEntity(AgendamentoDTO agendamentoDTO);

    // recebendo uma lista de agendamentos do banco em DTO
    List<AgendamentoDTO> toDTO(List<Agendamento> agendamento);
    //trocar os dados de AgendamentoDTO para Agendamento(entidade)
    @Mappings({
            @Mapping(source = "agendamentoDTO.id", target = "id"),
            @Mapping(source = "agendamentoDTO.data_inicio", target = "data_inicio"),
            @Mapping(source = "agendamentoDTO.data_fim", target = "data_fim"),
            @Mapping(source = "agendamentoDTO.observacao", target = "observacao"),
            @Mapping(source = "agendamentoDTO.servico", target = "servico"),
            @Mapping(source = "agendamentoDTO.pessoa", target = "pessoa"),


    })
    Agendamento updateEntity(AgendamentoDTO agendamentoDTO, Agendamento agendamento);

}