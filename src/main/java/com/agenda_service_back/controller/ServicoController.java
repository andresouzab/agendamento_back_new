package com.agenda_service_back.controller;


import com.agenda_service_back.DTO.ServicoDTO;
import com.agenda_service_back.service.ServicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //habilita REST
@RequestMapping ("/servicos") // localhost:8080/servicos
@CrossOrigin(origins = "http://localhost:5173")
public class ServicoController {
    @Autowired
    private ServicoService servicoService;

    @GetMapping // retorna uma lista de servicos
    public ResponseEntity<List<ServicoDTO>> getAllServico(){
        List<ServicoDTO> servicoDTO = servicoService.findAll();
        return ResponseEntity.ok(servicoDTO);
    }
    @GetMapping("/{id}") // localhost:8080/servicos/id
    public ResponseEntity<ServicoDTO> getServicoById(@PathVariable Integer id){
        ServicoDTO servicoDTO = servicoService.findById(id);
        return ResponseEntity.ok(servicoDTO);
    }
    @PostMapping
    public ResponseEntity<ServicoDTO> createServico(@Valid @RequestBody ServicoDTO servicoDTO){
        ServicoDTO createServicoDTO = servicoService.create(servicoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createServicoDTO);

    }
    @PutMapping("/{id}")
    public ResponseEntity<ServicoDTO> updateServico(@PathVariable Integer id, @Valid @RequestBody ServicoDTO servicoDTO){
        ServicoDTO updateServicoDTO = servicoService.update(id, servicoDTO);
        return ResponseEntity.ok(updateServicoDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Integer id){
        servicoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

