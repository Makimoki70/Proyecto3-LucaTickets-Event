package com.proyecto.spring.event.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.spring.event.model.Event;


import com.proyecto.spring.event.repository.EventRepository;


@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;		

	public Event addEvent(Event event)
	{		
		return eventRepository.save(event);
	}
	
	public List<Event> showAllEvents() {
		return eventRepository.findAll();
	}
	
	public List<Event> getEventName( String name) {
		return eventRepository.getEventName(name) ;
	}
}
