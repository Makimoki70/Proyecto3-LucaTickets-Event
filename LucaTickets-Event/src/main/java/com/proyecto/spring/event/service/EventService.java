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
		
		if (!Optional.of(event).isEmpty()) {
			
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


	public Event addEvent(Event event)
	{		
		return eventRepository.save(event);

	}
	
	public List<Event> showAllEvents() {
		
		return eventRepository.findAll();
		
		
		
	}

}
