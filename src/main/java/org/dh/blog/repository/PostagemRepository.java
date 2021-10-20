package org.dh.blog.repository;

import java.util.List;

import org.dh.blog.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>{

	public List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);

	public List<Postagem> findAllByTextoContainingIgnoreCase(String texto);

	//public List<Postagem> findAllByTitulo(String titulo);

	//public List<Postagem> findAllByTexto(String texto);

}
