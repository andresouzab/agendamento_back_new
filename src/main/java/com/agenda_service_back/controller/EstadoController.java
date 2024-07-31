package com.agenda_service_back.controller;


import com.agenda_service_back.DTO.EstadoDTO;
import com.agenda_service_back.service.EstadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //habilita REST
@RequestMapping ("/estados") // localhost:8080/estados
@CrossOrigin(origins = "http://localhost:5173")
public class EstadoController {
    @Autowired
    private EstadoService estadoService;

    @GetMapping // retorna uma lista de estados
    public ResponseEntity<List<EstadoDTO>> getAllEstados(){
        List<EstadoDTO> estadoDTO = estadoService.findAll();
        System.out.println(estadoDTO);
        return ResponseEntity.ok(estadoDTO);
    }
    @GetMapping("/{id}") // localhost:8080/estados/id
    public ResponseEntity<EstadoDTO> getEstadoById(@PathVariable Integer id){
        EstadoDTO estadoDTO = estadoService.findById(id);
        return ResponseEntity.ok(estadoDTO);
    }
    @PostMapping
    public ResponseEntity<EstadoDTO> createEstado(@Valid @RequestBody EstadoDTO estadoDTO){
        EstadoDTO createEstadoDTO = estadoService.create(estadoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createEstadoDTO);

    }
    @PutMapping("/{id}")
    public ResponseEntity<EstadoDTO> updateEstado(@PathVariable Integer id, @Valid @RequestBody EstadoDTO estadoDTO){
        EstadoDTO updateEstadoDTO = estadoService.update(id, estadoDTO);
        return ResponseEntity.ok(updateEstadoDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstado(@PathVariable Integer id){
        estadoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

