package com.agenda_service_back.mapper;

import com.agenda_service_back.DTO.ServicoDTO;
import com.agenda_service_back.entity.Servico;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServicoMapper {
    //Conversor Entity(Model) para DTO
    @Mapping(source = "id", target = "id")
    ServicoDTO toDTO(Servico servico);

    @Mapping(source = "servicoDTO.id", target="id")
    Servico toEntity(ServicoDTO servicoDTO);

    // recebendo uma lista de servicos do banco em DTO
    List<ServicoDTO> toDTO(List<Servico> servico);
    //trocar os dados de ServicoDTO para Servico(entidade)
    @Mappings({
            @Mapping(source = "servicoDTO.id", target = "id"),
            @Mapping(source = "servicoDTO.nome", target = "nome"),
            @Mapping(source = "servicoDTO.preco", target = "preco"),
            @Mapping(source = "servicoDTO.descricao", target = "descricao"),
            @Mapping(source = "servicoDTO.informacoes_extras", target = "informacoes_extras"),
            @Mapping(source = "servicoDTO.status", target = "status"),
            @Mapping(source = "servicoDTO.categoria", target = "categoria"),
            @Mapping(source = "servicoDTO.pessoaJuridica", target = "pessoaJuridica"),
            @Mapping(source = "servicoDTO.agendamento", target = "agendamento")

    })
    Servico updateEntity(ServicoDTO servicoDTO, Servico servico);

}