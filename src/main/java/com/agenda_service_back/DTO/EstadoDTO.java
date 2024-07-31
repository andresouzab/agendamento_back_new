package com.agenda_service_back.DTO;

import com.agenda_service_back.entity.Cidade;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;

public class EstadoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Integer id;

    @NotNull(message = "o campo NOME é requerido.")
    protected String nome;
    @NotNull(message = "o campo UF é requerido.")
    protected String uf;
    private List<Cidade> cidades;

    public EstadoDTO() {

    }
    public EstadoDTO(Integer id, String nome, String uf) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
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

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }
}
