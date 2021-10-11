package org.dh.blog.model;

import javax.persistence.*;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_postagem")
public class Postagem {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    public Postagem() {
    	super();
    }

    public Postagem(@NotNull @Size(min = 0, max = 100) String titulo,
    				@NotNull @Size(min = 0, max = 500) String texto, Date date) {
		this.titulo = titulo;
		this.texto = texto;
		this.date = date;
	}

	@NotNull
    @Size(min = 0, max=100)
    private String titulo;

    @NotNull
    @Size(min = 0, max=500)
    private String texto;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new java.sql.Date(System.currentTimeMillis());

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
