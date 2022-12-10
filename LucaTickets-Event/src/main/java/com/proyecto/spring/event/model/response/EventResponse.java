package com.proyecto.spring.event.model.response;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.spring.event.model.Event;
import com.proyecto.spring.event.model.Recinto;

import lombok.Data;

/**
 * 
 * Nombre de clase: EventResponse.
 * Descripcion: model DTO, para poder hacer adaptacion entre la clase Event y esta, de cara a MongoDB
 * Fecha: 09/12/2022
 * @author Joel y Alberto
 * @version 0.1
 * @since 0.1
 * 
 * */
public @Data class EventResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
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
	
	public static EventResponse of (Event event) {
		EventResponse eventResponse = new EventResponse();
		
		eventResponse.setNombre(event.getNombre());
		eventResponse.setCorta(event.getCorta());
		eventResponse.setExtendida(event.getExtendida());
		eventResponse.setNormas(event.getNormas());
		eventResponse.setFecha(event.getFecha());
		eventResponse.setHora(event.getHora());
		eventResponse.setPrecio(event.getPrecio());
		eventResponse.setSala(event.getSala());
		
		return eventResponse;	
	}
	
	public static List <EventResponse> of(List<Event> events){
		return events.stream()
				.map(eventos -> of(eventos))
				.collect(Collectors.toList());
	}
	
}
