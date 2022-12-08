package com.proyecto.spring.event.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;


import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

@RestController
@RequestMapping("/event")
@Tag(name = "event", description = "the event API")
public class EventController {
	private static final Logger logger = LoggerFactory.getLogger(EventController.class);
	
	@Autowired
	private EventService eventService;

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
		return ResponseEntity.of(Optional.of(eventService.addEvent(event)));
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
		return EventResponse.of(eventService.getEventsByName(name));
	}

	@Operation(summary = "Mostrar eventos que coincidan con un tipo de recinto dado", description = "Busca eventos en la BDD dado un tipo de recinto, devuelve una lista de  Event", tags= {"event"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Eventos mostrados", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Event.class)) }),
			@ApiResponse(responseCode = "400", description = "No válido (NO implementado) ", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Event.class)) }),
			})
	@GetMapping("/tipo/{tipo}")
	public List<Event> getEventsByType(
			@Parameter(description = "Tipo del lugar del evento", required=true) 
			@PathVariable String tipo){
		logger.info("------ readTipo (GET) ");
		return eventService.getEventByType(tipo);
	}
}
