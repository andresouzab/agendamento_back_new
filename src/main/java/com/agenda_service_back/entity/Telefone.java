package com.agenda_service_back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Telefone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String numero;

    @JsonIgnore
    @ManyToOne
    @JoinColumn (name = "pessoa_telefone")
    protected Pessoa pessoa;

    @JsonIgnore
    @ManyToOne
    @JoinColumn (name = "pessoaJuridica_telefone")
    protected PessoaJuridica pessoaJuridica;



    public Telefone() {
    }

    public Telefone(Integer id, String numero, Pessoa pessoa, PessoaJuridica pessoaJuridica) {
        this.id = id;
        this.numero = numero;
        this.pessoa = pessoa;
        this.pessoaJuridica = pessoaJuridica;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telefone telefone = (Telefone) o;
        return Objects.equals(id, telefone.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
