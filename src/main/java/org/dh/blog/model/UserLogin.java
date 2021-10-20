package org.dh.blog.model;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.UniqueConstraint;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

//@Entity
//@Table(name = "tb_userlogin")
public class UserLogin {
	
	public UserLogin() {
		// TODO Auto-generated constructor stub
	}
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
	
//	@NotNull
//	@Size(min = 2, max = 100)
	private String nome;
	
//	@NotNull
//	@Size(min = 5, max = 100)
//	@UniqueConstraint
	private String usuario;
	
//	@NotNull
//	@Size(min = 8, max = 16)
	private String senha;
	
	private String token;

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}