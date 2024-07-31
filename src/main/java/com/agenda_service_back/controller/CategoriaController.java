package com.agenda_service_back.controller;


import com.agenda_service_back.DTO.CategoriaDTO;
import com.agenda_service_back.entity.Categoria;
import com.agenda_service_back.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //habilita REST
@RequestMapping ("/categorias") // localhost:8080/categorias
@CrossOrigin(origins = "http://localhost:5173")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping // retorna uma lista de categorias
    public ResponseEntity<List<CategoriaDTO>> getAllCategorias(){
        List<CategoriaDTO> categoriasDTO = categoriaService.findAll();
        return ResponseEntity.ok(categoriasDTO);
    }
    @GetMapping("/{id}") // localhost:8080/categorias/id
    public ResponseEntity<CategoriaDTO> getCategoriaById(@PathVariable Integer id){
        CategoriaDTO categoriaDTO = categoriaService.findById(id);
        return ResponseEntity.ok(categoriaDTO);
    }
    @PostMapping
    public ResponseEntity<CategoriaDTO> createCategoria(@Valid @RequestBody CategoriaDTO categoriaDTO){
        CategoriaDTO createCategoriaDTO = categoriaService.create(categoriaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createCategoriaDTO);

    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> updateCategoria(@PathVariable Integer id, @Valid @RequestBody CategoriaDTO categoriaDTO){
        System.out.println("id" + id);
        System.out.println(categoriaDTO);
        CategoriaDTO updateCategoriaDTO = categoriaService.update(id, categoriaDTO);
        return ResponseEntity.ok(updateCategoriaDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Integer id){
        categoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

