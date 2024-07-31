package com.agenda_service_back.mapper;

import com.agenda_service_back.DTO.CategoriaDTO;
import com.agenda_service_back.entity.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    //Conversor Entity(Model) para DTO
    @Mapping(source = "id", target = "id")
    CategoriaDTO toDTO(Categoria categoria);

    @Mapping(source = "categoriaDTO.id", target="id")
    Categoria toEntity(CategoriaDTO categoriaDTO);

    // recebendo uma lista de categorias do banco em DTO
    List<CategoriaDTO> toDTO(List<Categoria> categorias);
    //trocar os dados de CategoriaDTO para Categoria(entidade)
    @Mappings({
            @Mapping(source = "categoriaDTO.id", target = "id"),
            @Mapping(source = "categoriaDTO.nome", target = "nome"),
            @Mapping(source = "categoriaDTO.descricao", target = "descricao")
    })
    Categoria updateEntity(CategoriaDTO categoriaDTO, Categoria categoria);

}