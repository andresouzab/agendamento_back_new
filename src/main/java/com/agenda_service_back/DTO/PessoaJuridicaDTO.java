package com.agenda_service_back.DTO;

import com.agenda_service_back.entity.Endereco;
import com.agenda_service_back.entity.Servico;
import com.agenda_service_back.entity.Telefone;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;

public class PessoaJuridicaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Integer id;

    @NotNull(message = "o campo NOME é requerido.")
    protected String nome;
    @NotNull(message = "o campo CNPJ é requerido.")
    protected String cnpj;
    @NotNull(message = "o campo RAZÃO SOCIAL é requerido.")
    protected String razao_social;
    @NotNull(message = "o campo EMAIL é requerido.")
    protected String email;
    @NotNull(message = "o campo SENHA é requerido.")
    protected String senha;

    protected List<Telefone> telefone;

    @NotNull(message = "o campo ENDEREÇO é requerido.")
    protected Endereco endereco;
    protected List<Servico> servico;


    public PessoaJuridicaDTO() {
    }

    public PessoaJuridicaDTO(Integer id, String nome, String cnpj, String razao_social, String email, String senha, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.razao_social = razao_social;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public List<Servico> getServico() {
        return servico;
    }

    public void setServico(List<Servico> servico) {
        this.servico = servico;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Telefone> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<Telefone> telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}


