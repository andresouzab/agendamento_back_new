package com.agenda_service_back.mapper;

import com.agenda_service_back.DTO.PessoaDTO;
import com.agenda_service_back.DTO.TelefoneDTO;
import com.agenda_service_back.entity.Pessoa;
import com.agenda_service_back.entity.Telefone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TelefoneMapper {
    //Conversor Entity(Model) para DTO
    @Mapping(source = "id", target = "id")
    TelefoneDTO toDTO(Telefone telefone);

    @Mapping(source = "telefoneDTO.id", target="id")
    Telefone toEntity(TelefoneDTO telefoneDTO);

    // recebendo uma lista de telefones do banco em DTO
    List<TelefoneDTO> toDTO(List<Telefone> telefone);
    //trocar os dados de TelefoneDTO para Estado(entidade)
    @Mappings({
            @Mapping(source = "telefoneDTO.id", target = "id"),
            @Mapping(source = "telefoneDTO.numero", target = "numero"),
            @Mapping(source = "telefoneDTO.pessoa", target = "pessoa"),
            @Mapping(source = "telefoneDTO.pessoaJuridica", target = "pessoaJuridica"),

    })
    Telefone updateEntity(TelefoneDTO telefoneDTO, Telefone telefone);

}