package com.proyecto.spring.event.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.spring.event.model.Event;
import com.proyecto.spring.event.service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@PostMapping("/add")
	public ResponseEntity<Event> addEvent(@RequestBody Event event)
	{	
		return ResponseEntity.of(Optional.of(eventService.addEvent(event)));
	}
	
	
}
