package com.agenda_service_back.DTO;


import jakarta.validation.constraints.NotNull;

import java.io.Serializable;


public class CategoriaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Integer id;
    @NotNull(message = "o campo NOME é requerido.")
    protected String nome;

    @NotNull(message = "o campo DESCRIÇÃO é requerido.")
    protected String descricao;

//    protected List<ServicDTO> servico;



    public CategoriaDTO() {

    }

    public CategoriaDTO(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}
