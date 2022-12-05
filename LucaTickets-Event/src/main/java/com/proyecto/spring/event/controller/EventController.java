package com.proyecto.spring.event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PostMapping("/{id}/add")
	public void addEvent(@PathVariable Long id, @RequestBody Event event)
	{
		
		eventService.addEvent(event);
		
	}
	
	
}
