package com.agenda_service_back.controller;


import com.agenda_service_back.DTO.TelefoneDTO;
import com.agenda_service_back.service.TelefoneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //habilita REST
@RequestMapping ("/telefones") // localhost:8080/telefones
@CrossOrigin(origins = "http://localhost:5173")
public class TelefoneController {
    @Autowired
    private TelefoneService telefoneService;

    @GetMapping // retorna uma lista de telefones
    public ResponseEntity<List<TelefoneDTO>> getAllTelefone(){
        List<TelefoneDTO> telefoneDTO = telefoneService.findAll();
        return ResponseEntity.ok(telefoneDTO);
    }
    @GetMapping("/{id}") // localhost:8080/telefones/id
    public ResponseEntity<TelefoneDTO> getTelefoneById(@PathVariable Integer id){
        TelefoneDTO telefoneDTO = telefoneService.findById(id);
        return ResponseEntity.ok(telefoneDTO);
    }
    @PostMapping
    public ResponseEntity<TelefoneDTO> createTelefone(@Valid @RequestBody TelefoneDTO telefoneDTO){
        TelefoneDTO createTelefoneDTO = telefoneService.create(telefoneDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createTelefoneDTO);

    }
    @PutMapping("/{id}")
    public ResponseEntity<TelefoneDTO> updateTelefone(@PathVariable Integer id, @Valid @RequestBody TelefoneDTO telefoneDTO){
        TelefoneDTO updateTelefoneDTO = telefoneService.update(id, telefoneDTO);
        return ResponseEntity.ok(updateTelefoneDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelefone(@PathVariable Integer id){
        telefoneService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

