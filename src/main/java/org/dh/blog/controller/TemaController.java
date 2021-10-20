package org.dh.blog.controller;

import java.util.List;

import org.dh.blog.model.Tema;
import org.dh.blog.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/temas")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class TemaController {

    @Autowired
    private TemaRepository repository;

    @GetMapping
    public ResponseEntity<List<Tema>> getAll(){
           return ResponseEntity.ok(repository.findAll());
    }
	
    @GetMapping("/{id}")
    public ResponseEntity<Tema> getById(@PathVariable Long id){
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp))  //option java - expressão lambda
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping ("/descricao/{descricao}")
    public ResponseEntity <List<Tema>> getByDescricao(@PathVariable String descricao){
        return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(descricao));
    }

    @PostMapping
    public ResponseEntity<Tema> post (@RequestBody Tema tema){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
    }
	
    @PutMapping
    public ResponseEntity<Tema> put (@RequestBody Tema tema){
        return ResponseEntity.ok(repository.save(tema));
    }
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id){
        repository.deleteById(id);
    }

}
