package com.proyecto.spring.event.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * Nombre de clase: Recinto.
 * Descripcion: Subclase model del microservicio Event, enlazado con la clase Event. Hace puente tambien con el Enum Tipo.
 * Fecha: 09/12/2022
 * @author Daniel Pareja
 * @version 0.1
 * @since 0.1
 * 
 * */
@NoArgsConstructor
@Getter
@Setter
@Schema(name="Recinto", description = "Subclase de la clase Event")
public class Recinto{
	
	/**
	 * 
	 * @param nombre: campo del nombre del recinto.
	 * 
	 * */
	private String nombre,
	
	/**
	 * 
	 * @param ciudad: ciudad donde se da lugar el evento.
	 * 
	 * */
	ciudad,
	
	/**
	 * 
	 * @param direccion: calle en la que se efectua el evento.
	 * 
	 * */
	direccion;
	
	/**
	 * 
	 * @param tipoRecinto: subclase tipo Enum enlazada.
	 * 
	 * */
	private Tipo tipoRecinto;
	
	/**
	 * 
	 * @param aforo: numero maximo de personas que pueden entrar en el recinto.
	 * 
	 * */
	private int aforo;
}