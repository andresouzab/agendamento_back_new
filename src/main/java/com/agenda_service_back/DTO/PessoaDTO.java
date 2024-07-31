package com.agenda_service_back.DTO;

import com.agenda_service_back.entity.Endereco;
import com.agenda_service_back.entity.Telefone;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PessoaDTO implements Serializable{
        private static final long serialVersionUID = 1L;

        protected Integer id;

        @NotNull(message = "o campo NOME é requerido.")
        protected String nome;

        @NotNull(message = "o campo CPF é requerido.")
        protected String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")

    @NotNull(message = "o campo DATA DE NASCIMENTO é requerido.")
        protected Date data_nascimento;
        @NotNull(message = "o campo EMAIL é requerido.")
        protected String email;

        @NotNull(message = "o campo SENHA é requerido.")
        protected String senha;

        protected List<Telefone> telefone;

        protected Endereco endereco;

    public PessoaDTO(Integer id, String nome, String cpf, Date data_nascimento, String email, String senha, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.data_nascimento = data_nascimento;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }

    public PessoaDTO() {

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }
}
