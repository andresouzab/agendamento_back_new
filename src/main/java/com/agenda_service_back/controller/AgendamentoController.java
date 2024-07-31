package com.agenda_service_back.controller;


import com.agenda_service_back.DTO.AgendamentoDTO;
import com.agenda_service_back.service.AgendamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //habilita REST
@RequestMapping ("/agendamentos") // localhost:8080/agendamentos
@CrossOrigin(origins = "http://localhost:5173")

public class AgendamentoController {
    @Autowired
    private AgendamentoService agendamentoService;

    @GetMapping // retorna uma lista de agendamentos
    public ResponseEntity<List<AgendamentoDTO>> getAllAgendamento(){
        List<AgendamentoDTO> agendamentoDTO = agendamentoService.findAll();
        return ResponseEntity.ok(agendamentoDTO);
    }
    @GetMapping("/{id}") // localhost:8080/agendamentos/id
    public ResponseEntity<AgendamentoDTO> getAgendamentoById(@PathVariable Integer id){
        AgendamentoDTO agendamentoDTO = agendamentoService.findById(id);
        return ResponseEntity.ok(agendamentoDTO);
    }
    @PostMapping
    public ResponseEntity<AgendamentoDTO> createAgendamento(@Valid @RequestBody AgendamentoDTO agendamentoDTO){
        AgendamentoDTO createAgendamentoDTO = agendamentoService.create(agendamentoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createAgendamentoDTO);

    }
    @PutMapping("/{id}")
    public ResponseEntity<AgendamentoDTO> updateAgendamento(@PathVariable Integer id, @Valid @RequestBody AgendamentoDTO agendamentoDTO){
        AgendamentoDTO updateAgendamentoDTO = agendamentoService.update(id, agendamentoDTO);
        return ResponseEntity.ok(updateAgendamentoDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgendamento(@PathVariable Integer id){
        agendamentoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

