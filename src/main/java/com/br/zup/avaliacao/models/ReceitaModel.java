package com.br.zup.avaliacao.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class ReceitaModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Insira o nome da sua receita.")
	@NotNull(message = "O campo Nome não pode ficar em branco")
	private String nome;
	
	@NotBlank(message = "Insira os ingredientes da sua receita.")
	@NotNull(message = "O campo Ingredientes não pode ficar em branco")
	private String ingredientes;
	
	@NotBlank(message = "Insira o modo de preparo da sua receita")
	@NotNull(message = "O campo Mode de preparo não pode ficar em branco")
	private String modoDePreparo;

	public ReceitaModel() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getModoDePreparo() {
		return modoDePreparo;
	}

	public void setModoDePreparo(String modoDePreparo) {
		this.modoDePreparo = modoDePreparo;
	}

}
