package com.proyecto.spring.event.model.response;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.proyecto.spring.event.model.Event;
import com.proyecto.spring.event.model.Recinto;

import lombok.Data;

public @Data class EventResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nombre, corta, extendida, foto, normas;
	private LocalDate fecha;
	private LocalDate hora, minimo, maximo;
	private Double precio;
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
