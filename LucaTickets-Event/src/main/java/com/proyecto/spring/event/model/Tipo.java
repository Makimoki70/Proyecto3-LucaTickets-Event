package com.proyecto.spring.event.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name="Tipo", description = "Subclase de la clase Recinto")
public enum Tipo{
	terraza("terraza"), interior("interior"), jardin("jardin");
	
	private String tipo;
	
	private Tipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return this.tipo;
	}
}