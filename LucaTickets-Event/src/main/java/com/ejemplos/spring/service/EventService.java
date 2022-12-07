package com.ejemplos.spring.service;

import java.util.List;
import java.util.Optional;

import com.ejemplos.spring.model.Event;

public interface EventService {
	
	// Return all students
	public List<Event> findAll();
	
	// Find the student with this id
	public Optional<Event> findById(long id);

	// Save a new student & update
	public Event save(Event event);
	// EN SpringJPA no hay metodo Update
	public Optional<Event> update(Event event);

	// Delete student with this id
	public void deleteById(Long id);

	// Busca por tipo.
	public List<Event> findByTipo(String tipo);
}