package com.agenda_service_back.controller;


import com.agenda_service_back.DTO.PessoaJuridicaDTO;
import com.agenda_service_back.service.PessoaJuridicaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController //habilita REST
@RequestMapping ("/pessoa_juridica") // localhost:8080/pessoa_juridica
@CrossOrigin(origins = "http://localhost:5173")
public class PessoaJuridicaController {
    @Autowired
    private PessoaJuridicaService pessoaJuridicaService;

    @GetMapping // retorna uma lista de pessoas juridicas
    public ResponseEntity<List<PessoaJuridicaDTO>> getAllPessoasJuridicas(){
        List<PessoaJuridicaDTO> pessoaJuridicaDTO = pessoaJuridicaService.findAll();
        return ResponseEntity.ok(pessoaJuridicaDTO);
    }
    @GetMapping("/{id}") // localhost:8080/pessoas_juridicas/id
    public ResponseEntity<PessoaJuridicaDTO> getPessoaJuridicaById(@PathVariable Integer id){
        PessoaJuridicaDTO pessoaJuridicaDTO = pessoaJuridicaService.findById(id);
        return ResponseEntity.ok(pessoaJuridicaDTO);
    }
    @PostMapping
    public ResponseEntity<PessoaJuridicaDTO> createPessoaJuridica(@Valid @RequestBody PessoaJuridicaDTO pessoaJuridicaDTO){
        PessoaJuridicaDTO createPessoaJuridicaDTO = pessoaJuridicaService.create(pessoaJuridicaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createPessoaJuridicaDTO);

    }
    @PutMapping("/{id}")
    public ResponseEntity<PessoaJuridicaDTO> updatePessoaJuridica(@PathVariable Integer id, @Valid @RequestBody PessoaJuridicaDTO pessoaJuridicaDTO){
        PessoaJuridicaDTO updatePessoaJuridicaDTO = pessoaJuridicaService.update(id, pessoaJuridicaDTO);
        return ResponseEntity.ok(updatePessoaJuridicaDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePessoaJuridica(@PathVariable Integer id){
        pessoaJuridicaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


//    // Novo método para buscar prestadores por servico_id
//    @GetMapping("/search")
//    public ResponseEntity<List<PessoaJuridicaDTO>> getPessoaJuridicaByServicoNome(@RequestParam String servicoNome) {
//        System.out.println("servico_nome:"+servicoNome);
//        if (servicoNome == null || servicoNome.trim().isEmpty()) {
//            return ResponseEntity.badRequest().body(Collections.emptyList());
//        }
//        System.out.println("depois do servico nome");
//        try {
//            System.out.println("antes da lista de prestador");
//            List<PessoaJuridicaDTO> pessoaJuridica = pessoaJuridicaService.findByServicoNome(servicoNome);
//            System.out.println("lista de prestadores:"+pessoaJuridica);
//            return ResponseEntity.ok(pessoaJuridica);
//        } catch (Exception e) {
//            // Log the exception (e.g., using SLF4J or another logging framework)
//            // logger.error("Error while fetching prestadores by servicoNome: {}", servicoNome, e);
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
//        }
//}
}

