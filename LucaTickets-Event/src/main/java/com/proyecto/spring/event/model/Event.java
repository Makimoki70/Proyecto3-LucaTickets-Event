package com.proyecto.spring.event.model;


import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.annotation.Id;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Nombre de clase: Event.
 * Descripcion: Clase model del microservicio Event. Hace puente con la subclase Recinto.
 * Fecha: 09/12/2022
 * @author Daniel Pareja
 * @version 0.1
 * @since 0.1
 * 
 * */
@NoArgsConstructor
@Data
@Schema(name="Event", description = "Event Class")
public class Event{

	/**
	 * 
	 * @param id: Campo identificativo del resgistro
	 * 
	 * */
	@Id
	@Schema(name= "id", 
	description = "Identificador único para el evento", 
    example = "42", 
    required = true)
	public Long id;
	
	/**
	 * 
	 * @param nombre: Como se llama el evento
	 * 
	 * */
	private String nombre,
	
	/**
	 * 
	 * @param corta: Descripcion corta del evento
	 * 
	 * */
	corta,
	
	/**
	 * 
	 * @param extendida: Descripcion larga del evento
	 * 
	 * */
	extendida,
	
	/**
	 * 
	 * @param foto: Imagen descriptiva del evento
	 * 
	 * */
	foto,
	
	/**
	 * 
	 * @param normas: Las normas de conducta para asistir al evento
	 * 
	 * */
	normas;
	
	/**
	 * 
	 * @param Fecha: Dia del calendario en el que da inicio el evento
	 * 
	 * */
	private LocalDate fecha;
	
	/**
	 * 
	 * @param hora: Hora a la que comienza el evento
	 * 
	 * */
	private LocalTime hora,
	
	/**
	 * 
	 * @param minimo: Hora minima, coincide con la hora de inicio del evento
	 * 
	 * */
	minimo,
	
	/**
	 * 
	 * @param maximo: Hora a la que comienza el evento
	 * 
	 * */
	maximo;
	
	/**
	 * 
	 * @param precio: Precio de venta del evento
	 * 
	 * */
	private Double precio;
	
	/**
	 * 
	 * @param sala: Tipo de sala en la que se efectua el evento
	 * 
	 * */
	private Recinto sala;
}