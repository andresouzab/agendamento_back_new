package com.agenda_service_back.DTO;

import com.agenda_service_back.entity.Pessoa;
import com.agenda_service_back.entity.Servico;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;

public class AgendamentoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    protected Integer id;
    @NotNull(message = "O campo DATA DE INICIO é requerido")
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate data_inicio;
    @NotNull(message = "O campo DATA FINAL é requerido")
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate data_fim;
    @NotNull(message = "O campo OBSERVAÇÃO é requerido")
    protected String observacao;

    protected Servico servico;

    protected Pessoa pessoa;


    public AgendamentoDTO() {

    }

    public AgendamentoDTO(Integer id, LocalDate data_inicio, LocalDate data_fim, String observacao, Servico servico, Pessoa pessoa) {
        this.id = id;
        this.data_inicio = data_inicio;
        this.data_fim = data_fim;
        this.observacao = observacao;
        this.servico = servico;
        this.pessoa = pessoa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(LocalDate data_inicio) {
        this.data_inicio = data_inicio;
    }

    public LocalDate getData_fim() {
        return data_fim;
    }

    public void setData_fim(LocalDate data_fim) {
        this.data_fim = data_fim;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}

