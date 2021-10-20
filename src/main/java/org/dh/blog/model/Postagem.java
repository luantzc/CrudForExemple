package org.dh.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name = "postagem")
public class Postagem {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Postagem() {
    	super();
    }
    
    /* public Postagem(@NotNull @Size(min = 0, max = 100) String titulo,
    				@NotNull @Size(min = 0, max = 500) String texto, Date date) {
		this.titulo = titulo;
		this.texto = texto;
		this.data = date;
	}*/

    @NotNull
    @Size (min = 5, max = 100)
    private String titulo;
    @NotNull
    @Size (min = 5, max = 500)
    private String texto;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datet = new java.sql.Date(System.currentTimeMillis());


    @ManyToOne
    @JsonIgnoreProperties("postagem") //evitar um problema - recursividade
    private Tema tema;
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getDatet() {
        return datet;
    }

    public void setDatet(Date datet) {
        this.datet = datet;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }
	
}