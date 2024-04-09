package br.ufrj.hucff.crud.modelo;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private String rua;
	private Integer numero;
	private String bairro;
	private Integer cep;
	
	
	public Endereco() {} 
	
	public Endereco(String rua, Integer numero, String bairro, Integer cep) {
		this.rua = rua;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public Integer getCep() {
		return cep;
	}
	public void setCep(Integer cep) {
		this.cep = cep;
	}
}
