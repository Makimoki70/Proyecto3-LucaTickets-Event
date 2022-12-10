package com.proyecto.spring.event.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.spring.event.model.Event;


import com.proyecto.spring.event.repository.EventRepository;


/**
 * 
 * Nombre de clase: EventService
 * Descripcion: Clase de la capa service, añade los siguientes metodos:
 * deleteById, que opcionalmente borrara un evento por id si lo encuentra en la base de datos.
 * updateEvent, que opcionalmente actualizara un evento por id si lo encuentra en la base de datos.
 * addEvent, el cual guarda el evento actual dentro de la base de datos.
 * showAllEvents, que mostrara todos los eventos actualmente guardados.
 * getEventsByName, que filtra entre los eventos y busca por nombre.
 * getEventsByType, que filtra entre los eventos y busca por tipo de sala de recinto.
 * Fecha: 05/12/2022
 * @author Joel y Alberto
 * @version 0.1
 * @since 0.1
 * 
 * */
@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;		

	/**
     * Método puente con EventRepository que borra los datos de un Event.
     * @return el evento a eliminar
     */
	public Optional<Event> deleteById(Long id) {
		Optional<Event> event  = eventRepository.findById(id);
		if (!Optional.of(event).isEmpty()) {
			eventRepository.deleteById(id);					
		}		
		return event;	
	}

	/**
     * Método puente con EventRepository que updatea los datos de un Event.
     * @return el evento tratado actual
     */
	public Optional<Event> updateEvent(Event event){
		Optional<Event> currentEvent  = eventRepository.findById(event.getId());
		if (!currentEvent.isEmpty())
		{
			eventRepository.save(event);
		}
		return currentEvent;
	}
	/**
     * Método puente con EventRepository que pasa los datos de Event a la capa repository
     * @return el objeto entity guardado (.save) en el repository
     */
	public Event addEvent(Event event)
	{		
		return eventRepository.save(event);
	}
	
	/**
     * Método puente con EventRepository que pasa los datos de Event a la capa repository
     * @return el listado de eventos actuales en el repository
     */
	public List<Event> showAllEvents() {
		return eventRepository.findAll();
	}
	
	/**
     * Método puente con EventRepository que pasa los datos de Event a la capa repository
     * @return el listado de eventos actuales en el repository filtrado por nombre
     */
	public List<Event> getEventsByName( String name) {
		return eventRepository.getEventsByName(name) ;
	}
	
	/**
     * Método puente con EventRepository que pasa los datos de Event a la capa repository
     * @return el listado de eventos actuales en el repository filtrado por tipo
     */
	public List<Event> getEventByType(String tipo){
		return eventRepository.getEventsByType(tipo);
	}
}
