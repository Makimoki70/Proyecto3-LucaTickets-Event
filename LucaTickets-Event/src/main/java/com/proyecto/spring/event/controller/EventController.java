package com.proyecto.spring.event.controller;


import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;


import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.proyecto.spring.event.controller.error.EventNotFoundException;
import com.proyecto.spring.event.model.Event;
import com.proyecto.spring.event.model.response.EventResponse;
import com.proyecto.spring.event.service.EventService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * Nombre de clase: EventController. Descripcion: Controlador del microservicio Event.
 * Implementa el metodo add a la base de datos, las busquedas por nombre y tipo de evento.
 * Fecha: 09/12/2022
 * 
 * @author Alberto Egea y Joel Pascual
 * @version 0.2
 * @since 0.1
 * 
 */

@RestController
@RequestMapping("/event")
@Tag(name = "event", description = "the event API")
public class EventController {
	private static final Logger logger = LoggerFactory.getLogger(EventController.class);
	
	@Autowired
	private EventService eventService;

	@Operation(summary = "Eliminar un evento por Id", description = "Elimina un evento de la BDD, devuelve un opcional", tags= {"event"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Evento eliminado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Event.class)) }),
			@ApiResponse(responseCode = "400", description = "Evento no encontrado ", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Event.class)) }),
			})
	@DeleteMapping("/{id}")
	public Optional<Event> deleteById(@PathVariable Long id){
		Event event = eventService.deleteById(id).orElseThrow(() -> new EventNotFoundException(id));
		
		return Optional.ofNullable(event);
	}

	@Operation(summary = "Modificar eventos", 
			description = "Modifica un evento, si este se encuentra", tags= {"search"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista devuelta", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = EventResponse.class)) }),
			@ApiResponse(responseCode = "400", description = "No válido (NO implementado) ", content = @Content),
			})
	@PutMapping("/update")
	public ResponseEntity<Event> updateEvent(@RequestBody Event event){
		Event result = eventService.updateEvent(event).orElseThrow(() -> new EventNotFoundException(event.getId()));
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri();
		return ResponseEntity.created(location).body(result);
	}
	
	@Operation(summary = "Mostrar todos los eventos disponibles", description = "Busca todos los eventos de la BDD, devuelve una lista de Event", tags= {"event"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Eventos mostrados", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Event.class)) }),
			@ApiResponse(responseCode = "400", description = "No hay eventos disponibles ", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Event.class)) }),
			})
	@GetMapping("/")
	public List<EventResponse> getAllEvents(){
		return EventResponse.of(eventService.showAllEvents());
	}
	
	@Operation(summary = "Añadir evento", description = "Añade un evento a la BDD, devuelve un objeto Event", tags= {"event"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Evento creado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Event.class)) }),
			@ApiResponse(responseCode = "400", description = "No válido (NO implementado) ", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Event.class)) }),
			})
	@PostMapping("/add")
	public ResponseEntity<Event> addEvent(@RequestBody Event event)
	{	
		Event result = eventService.addEvent(event).orElseThrow(() -> new EventNotFoundException(event.getId()));
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId()).toUri();
		return ResponseEntity.created(location).body(result);
	}

	@Operation(summary = "Mostrar eventos que coincidan con un nombre dado", description = "Busca eventos en la BDD dado un nombre, devulve una lista de Event", tags= {"event"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Eventos mostrados", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Event.class)) }),
			@ApiResponse(responseCode = "400", description = "No válido (NO implementado) ", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Event.class)) }),
			})
	@GetMapping("/name/{name}")
	public List<EventResponse> getEventsByName(@PathVariable String name) {
		Optional<List<Event>> events = eventService.getEventsByName(name);
		List<EventResponse> eventsResponse = EventResponse.of(events.orElseThrow(() -> new EventNotFoundException()));
		return eventsResponse;
	}

	@Operation(summary = "Mostrar eventos que coincidan con un tipo de recinto dado", description = "Busca eventos en la BDD dado un tipo de recinto, devuelve una lista de  Event", tags= {"event"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Eventos mostrados", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Event.class)) }),
			@ApiResponse(responseCode = "400", description = "No válido (NO implementado) ", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Event.class)) }),
			})
	@GetMapping("/tipo/{tipo}")
	public List<EventResponse> getEventsByType(
			@Parameter(description = "Tipo del lugar del evento", required=true) 
			@PathVariable String tipo){
		logger.info("------ readTipo (GET) ");
		Optional<List<Event>> events = eventService.getEventsByType(tipo);
		logger.info("----------------------- " + events);
		List<EventResponse> eventsResponse = EventResponse.of(events.orElseThrow(() -> new EventNotFoundException()));
		return eventsResponse;
	}
}
