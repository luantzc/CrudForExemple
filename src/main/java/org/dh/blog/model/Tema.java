package org.dh.blog.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb_tema")
public class Tema {
    
    public Tema() {
    	super();
    }

    public Tema(@NotNull @Size(min = 1, max = 32) String descricao) {
		this.descricao = descricao;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 100)
    private String descricao;
	
	
    @OneToMany(mappedBy = "tema", cascade = CascadeType.ALL)  //INTEGRIDADE DO BANCO
    @JsonIgnoreProperties("tema")
    private List<Postagem> postagem;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Postagem> getPostagem() {
        return postagem;
    }

    public void setPostagem(List<Postagem> postagem) {
        this.postagem = postagem;
    }
    
}
