package com.ejemplos.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplos.spring.model.Event;
import com.ejemplos.spring.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService  {
	
	@Autowired
	private EventRepository repo;

	@Override
	public List<Event> findAll() {
		return repo.findAll();
	}

	@Override
	public Optional<Event> findById(long id) {
		return repo.findById(id);
	}
	
	@Override
	public List<Event> findByTipo(String tipo){
		return repo.findByTipo(tipo);
	}

	@Override
	public Event save(Event event) {
		return repo.save(event);
	}
	
	// EN SpringJPA no hay metodo Update
	@Override
	public Optional<Event> update(Event event) {
		return repo.update(event);
	}

	@Override
	public void deleteById(Long id) {
		repo.deleteById(id);
	}

}
