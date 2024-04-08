package br.ufrj.hucff.crud.modelo;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String nome;
	private Integer idade;
	private String[] prontuarios;
	@ManyToMany
	private Set<Profissao> profissoes = new HashSet<Profissao>();
	
	public Paciente() {}
	
	public Paciente(String nome, Integer idade, String[] prontuarios, Set<Profissao> profissoes) {
		this.nome = nome;
		this.idade = idade;
		this.prontuarios = prontuarios;
		this.profissoes = profissoes;
	}

	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String[] getProntuarios() {
		return prontuarios;
	}

	public void setProntuarios(String[] prontuarios) {
		this.prontuarios = prontuarios;
	}

	public Set<Profissao> getProfissoes() {
		return profissoes;
	}

	public void setProfissoes(Set<Profissao> profissoes) {
		this.profissoes = profissoes;
	}
}
