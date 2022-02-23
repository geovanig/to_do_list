package com.geovani.todolist.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "email", nullable = false)
	//@Schema(example = "email@email.com.br")
	private String email;
	
	@Column(name = "senha", nullable = false)
	private String senha;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List<Tarefa> tarefa;

	public Usuario() {}
	
	public Usuario(long id, String nome, String email, String senha, List<Tarefa> tarefa) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.tarefa = tarefa;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Tarefa> getTarefa() {
		return tarefa;
	}
	public void setTarefa(List<Tarefa> tarefa) {
		this.tarefa = tarefa;
	}

}
