package com.proyecto.spring.event.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.spring.event.model.Event;
import com.proyecto.spring.event.model.Recinto;
import com.proyecto.spring.event.repository.EventRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;
		
	public void addEvent(Event event)
	{		
		
		eventRepository.save(event);
		
	}

}
