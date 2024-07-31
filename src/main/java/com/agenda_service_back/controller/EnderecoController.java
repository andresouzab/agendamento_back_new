package com.agenda_service_back.controller;


import com.agenda_service_back.DTO.EnderecoDTO;
import com.agenda_service_back.service.EnderecoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //habilita REST
@RequestMapping ("/enderecos") // localhost:8080/enderecos
@CrossOrigin(origins = "http://localhost:5173")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping // retorna uma lista de endereco
    public ResponseEntity<List<EnderecoDTO>> getAllEnderecos(){
        List<EnderecoDTO> enderecoDTO = enderecoService.findAll();
        return ResponseEntity.ok(enderecoDTO);
    }
    @GetMapping("/{id}") // localhost:8080/enderecos/id
    public ResponseEntity<EnderecoDTO> getEnderecoById(@PathVariable Integer id){
        EnderecoDTO enderecoDTO = enderecoService.findById(id);
        return ResponseEntity.ok(enderecoDTO);
    }
    @PostMapping
    public ResponseEntity<EnderecoDTO> createEndereco(@Valid @RequestBody EnderecoDTO enderecoDTO){
        EnderecoDTO createEnderecoDTO = enderecoService.create(enderecoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createEnderecoDTO);

    }
    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTO> updateEndereco(@PathVariable Integer id, @Valid @RequestBody EnderecoDTO enderecoDTO){
        System.out.println(enderecoDTO);
        EnderecoDTO updateEnderecoDTO = enderecoService.update(id, enderecoDTO);
        System.out.println(updateEnderecoDTO);
        return ResponseEntity.ok(updateEnderecoDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable Integer id){
        enderecoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

