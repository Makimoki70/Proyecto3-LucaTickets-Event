package com.ejemplos.spring.repository;


import java.util.List;
import java.util.Optional;

import com.ejemplos.spring.model.Event;
import com.ejemplos.spring.secundario.Tipo;

public interface EventRepository {
	
	// Return all students
	public List<Event> findAll();
	
	// Find the student with this id
	public Optional<Event> findById(Long id);
	
	// Encuentra según el tipo del recinto.
	public List<Event> findByTipo(String tipo);

	// Save a new student & update
	public Event save(Event event);
	// EN SpringJPA no hay metodo Update
	public Optional<Event> update(Event event);

	// Delete student with this id
	public void deleteById(Long id);

}
