package br.ufrj.hucff.crud.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Paciente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String nome;
	private Integer idade;
	private String[] prontuarios;
	@ManyToMany
	private List<Profissao> profissoes = new ArrayList<>();
	@OneToOne(cascade=CascadeType.PERSIST)
	private Endereco endereco;
	
	public Paciente() {}
	
	public Paciente(String nome, Integer idade, String[] prontuarios, List<Profissao> profissoes, Endereco endereco) {
		this.nome = nome;
		this.idade = idade;
		this.prontuarios = prontuarios;
		this.profissoes = profissoes;
		this.endereco = endereco;
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

	public List<Profissao> getProfissoes() {
		return profissoes;
	}

	public void setProfissoes(List<Profissao> profissoes) {
		this.profissoes = profissoes;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
