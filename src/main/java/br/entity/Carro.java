package br.entity;

import javax.json.bind.annotation.JsonbTransient;

public class Carro {

	@JsonbTransient
	private Long id;
	private String modelo;

	public Carro(Long id, String modelo) {
		super();
		this.id = id;
		this.modelo = modelo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

}
