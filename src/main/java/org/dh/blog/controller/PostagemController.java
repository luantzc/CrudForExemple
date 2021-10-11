package org.dh.blog.controller;

import org.dh.blog.exception.NaoEncontradoException;
import org.dh.blog.model.Postagem;
import org.dh.blog.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/")
public class PostagemController{

	@Autowired
	private PostagemRepository postagemRepository;
	
	//pegar todas
	@GetMapping
	public List<Postagem> getPostagens(){
		return this.postagemRepository.findAll();
	}
	
	//pegar postagem
	@GetMapping("/Postagem-{id}")
	public Postagem getPostagemPorId(@PathVariable(value = "id") long postagemId){
		return this.postagemRepository.findById(postagemId)
				.orElseThrow(() -> new NaoEncontradoException("Erro 404 - Postagem não encontrada"));
	}
	
	//criar postagem
	@PostMapping
	public Postagem novaPostagem(@RequestBody Postagem postagem) {
		return this.postagemRepository.save(postagem);
	}
	
	//editar postagem
	@PutMapping("/Postagem-{id}")
	public Postagem editarPostagem(@RequestBody Postagem postagem, @PathVariable("id") long postagemId) {
		Postagem postagemEncontrada = this.postagemRepository.findById(postagemId)
				.orElseThrow(() -> new NaoEncontradoException("Erro 404 - Postagem não encontrada"));
		postagemEncontrada.setTitulo(postagem.getTitulo());
		postagemEncontrada.setTexto(postagem.getTexto());
		postagemEncontrada.setDate(postagem.getDate());
		return this.postagemRepository.save(postagemEncontrada);
	}
	
	//deletar postagem
	@DeleteMapping("/Postagem-{id}")
	public ResponseEntity<Postagem> deletarPostagem(@PathVariable ("id") long postagemId){
		Postagem postagemEncontrada = this.postagemRepository.findById(postagemId)
				.orElseThrow(() -> new NaoEncontradoException("Erro 404 - Postagem não encontrada"));
		this.postagemRepository.delete(postagemEncontrada);
		return ResponseEntity.ok().build();
	}
	
	/*
    @GetMapping
    public String postagem(){
        return "Works!";
    }

    @PostMapping
    @ResponseBody
    public String postagens( @RequestParam String nome,
                             @RequestParam String sobrenome){
        return nome + " " + sobrenome;
    }
    */
}
