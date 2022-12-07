package com.proyecto.spring.event.controller;


import java.util.List;

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
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/event")
@Tag(name = "event", description = "the event API")
public class EventController {
	
	@Autowired
	private EventService eventService;

	@Operation(summary = "Mostrar todos los eventos disponibles", description = "Añade un evento a la BBDD, devuelve un objeto Event", tags= {"event"})
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
	
	
	
	@Operation(summary = "Añadir evento", description = "Añade un evento a la BBDD, devuelve un objeto Event", tags= {"event"})
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
	
	@GetMapping("/name")
	public List<EventResponse> getEventName(@PathVariable String name) {
		return EventResponse.of(eventService.getEventName(name));
	
	
	}
}
