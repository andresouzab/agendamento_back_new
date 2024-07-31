package com.agenda_service_back.DTO;

import com.agenda_service_back.entity.Pessoa;
import com.agenda_service_back.entity.PessoaJuridica;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class TelefoneDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Integer id;

    @NotNull(message = "O campo NUMERO é requerido")
    protected String numero;
    protected Pessoa pessoa;
    protected PessoaJuridica pessoaJuridica;


    public TelefoneDTO(Integer id, String numero, Pessoa pessoa, PessoaJuridica pessoaJuridica) {
        this.id = id;
        this.numero = numero;
        this.pessoa = pessoa;
        this.pessoaJuridica = pessoaJuridica;
    }

    public TelefoneDTO() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }
}
