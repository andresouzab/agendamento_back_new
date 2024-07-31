package com.agenda_service_back.mapper;

import com.agenda_service_back.DTO.EnderecoDTO;
import com.agenda_service_back.entity.Endereco;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {
    //Conversor Entity(Model) para DTO
    @Mapping(source = "id", target = "id")
    EnderecoDTO toDTO(Endereco endereco);

    @Mapping(source = "enderecoDTO.id", target="id")
    Endereco toEntity(EnderecoDTO enderecoDTO);

    // recebendo uma lista de enderecos do banco em DTO
    List<EnderecoDTO> toDTO(List<Endereco> endereco);
    //trocar os dados de EnderecoDTO para Endereco(entidade)
    @Mappings({
            @Mapping(source = "enderecoDTO.id", target = "id"),
            @Mapping(source = "enderecoDTO.rua", target = "rua"),
            @Mapping(source = "enderecoDTO.cep", target = "cep"),
            @Mapping(source = "enderecoDTO.numero", target = "numero"),
            @Mapping(source = "enderecoDTO.complemento", target = "complemento"),
            @Mapping(source = "enderecoDTO.bairro", target = "bairro"),
            @Mapping(source = "enderecoDTO.cidade", target = "cidade"),
            @Mapping(source = "enderecoDTO.pessoas", target = "pessoas"),
            @Mapping(source = "enderecoDTO.pessoasJuridicas", target = "pessoasJuridicas")
    })
    Endereco updateEntity(EnderecoDTO enderecoDTO, Endereco endereco);

}