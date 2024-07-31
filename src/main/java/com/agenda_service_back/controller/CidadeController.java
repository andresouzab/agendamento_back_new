package com.agenda_service_back.controller;


import com.agenda_service_back.DTO.CidadeDTO;
import com.agenda_service_back.entity.Cidade;
import com.agenda_service_back.service.CidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //habilita REST
@RequestMapping ("/cidades") // localhost:8080/cidades
@CrossOrigin(origins = "http://localhost:5173")
public class CidadeController {
    @Autowired
    private CidadeService cidadeService;

    @GetMapping // retorna uma lista de cidades
    public ResponseEntity<List<CidadeDTO>> getAllCidades(){
        List<CidadeDTO> cidadeDTO = cidadeService.findAll();
        return ResponseEntity.ok(cidadeDTO);
    }
    @GetMapping("/{id}") // localhost:8080/cidades/id
    public ResponseEntity<CidadeDTO> getCidadeById(@PathVariable Integer id){
        CidadeDTO cidadeDTO = cidadeService.findById(id);
        return ResponseEntity.ok(cidadeDTO);
    }
    @PostMapping
    public ResponseEntity<CidadeDTO> createCidade(@Valid @RequestBody CidadeDTO cidadeDTO){
        CidadeDTO createCidadeDTO = cidadeService.create(cidadeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createCidadeDTO);

    }
    @PutMapping("/{id}")
    public ResponseEntity<CidadeDTO> updateCidade(@PathVariable Integer id, @Valid @RequestBody CidadeDTO cidadeDTO){
        CidadeDTO updateCidadeDTO = cidadeService.update(id, cidadeDTO);
        return ResponseEntity.ok(updateCidadeDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCidade(@PathVariable Integer id){
        cidadeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

