package com.agenda_service_back.controller;


import com.agenda_service_back.DTO.PessoaDTO;
import com.agenda_service_back.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //habilita REST
@RequestMapping ("/pessoas") // localhost:8080/pessoas
@CrossOrigin(origins = "http://localhost:5173")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping // retorna uma lista de pessoas
    public ResponseEntity<List<PessoaDTO>> getAllPessoas(){
        List<PessoaDTO> pessoaDTO = pessoaService.findAll();
        return ResponseEntity.ok(pessoaDTO);
    }
    @GetMapping("/{id}") // localhost:8080/pessoas/id
    public ResponseEntity<PessoaDTO> getPessoaById(@PathVariable Integer id){
        PessoaDTO pessoaDTO = pessoaService.findById(id);
        return ResponseEntity.ok(pessoaDTO);
    }
    @PostMapping
    public ResponseEntity<PessoaDTO> createPessoa(@Valid @RequestBody PessoaDTO pessoaDTO){
        PessoaDTO createPessoaDTO = pessoaService.create(pessoaDTO);
        System.out.println(createPessoaDTO);
        System.out.println(pessoaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createPessoaDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PessoaDTO> updatePessoa(@PathVariable Integer id, @Valid @RequestBody PessoaDTO pessoaDTO){
        PessoaDTO updatePessoaDTO = pessoaService.update(id, pessoaDTO);
        return ResponseEntity.ok(updatePessoaDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoa(@PathVariable Integer id){
        pessoaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

