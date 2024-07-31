package com.agenda_service_back.DTO;

import com.agenda_service_back.entity.Cidade;

import com.agenda_service_back.entity.Pessoa;
import com.agenda_service_back.entity.PessoaJuridica;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    protected Integer id;

    @NotNull(message = "o campo RUA é requerido.")
    protected String rua;
    @NotNull(message = "o campo CEP é requerido.")
    protected String cep;
    @NotNull(message = "o campo NUMERO é requerido.")
    protected Integer numero;
    @NotNull(message = "o campo COMPLEMENTO é requerido.")
    protected String complemento;
    @NotNull(message = "o campo BAIRRO é requerido.")
    protected String bairro;
    @NotNull(message = "o campo CIDADE é requerido.")

    protected Cidade cidade;

    protected List<Pessoa> pessoas;

    protected List<PessoaJuridica> pessoasJuridicas;



    public EnderecoDTO(Integer id, String rua, String cep, Integer numero, String complemento, String bairro, Cidade cidade) {
        this.id = id;
        this.rua = rua;
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public EnderecoDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public List<PessoaJuridica> getPessoasJuridicas() {
        return pessoasJuridicas;
    }

    public void setPessoasJuridicas(List<PessoaJuridica> pessoasJuridicas) {
        this.pessoasJuridicas = pessoasJuridicas;
    }

    @Override
    public String toString() {
        return "EnderecoDTO{" +
                "id=" + id +
                ", rua='" + rua + '\'' +
                ", cep='" + cep + '\'' +
                ", numero=" + numero +
                ", complemento='" + complemento + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade=" + cidade +
                '}';
    }
}
