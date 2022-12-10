package com.proyecto.spring.event.service;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.proyecto.spring.event.model.Event;
import com.proyecto.spring.event.repository.EventRepository;


@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;	
	
	public Optional<Event> deleteById(Long id) {
		Optional<Event> event  = eventRepository.findById(id);
		if (!Optional.ofNullable(event).isEmpty()) {
			eventRepository.deleteById(id);					
		}		
		return event;	
	}

	public Optional<Event> updateEvent(Event event){
		Optional<Event> currentEvent  = eventRepository.findById(event.getId());
		if (!currentEvent.isEmpty())
		{
			eventRepository.save(event);
		}
		return currentEvent;
	}

	public Optional<Event> addEvent(Event event)
	{		
		Optional<Event> currentEvent  = eventRepository.findById(event.getId());
		if (currentEvent.isEmpty())
		{
			currentEvent = Optional.of(eventRepository.save(event));
		}else currentEvent = Optional.ofNullable(null);
		
		return currentEvent;
	}
	
	public List<Event> showAllEvents() {
		return eventRepository.findAll();
	}
	
	public Optional<List<Event>> getEventsByName( String name) {
		List<Event> events = eventRepository.getEventsByName(name);
		if (events.isEmpty()) return Optional.ofNullable(null);
		return Optional.of(events);
	}
	
	public Optional<List<Event>> getEventsByType(String tipo){
		List<Event> events = eventRepository.getEventsByType(tipo);
		if (events.isEmpty()) return Optional.ofNullable(null);
		return Optional.of(events);
	}
}
