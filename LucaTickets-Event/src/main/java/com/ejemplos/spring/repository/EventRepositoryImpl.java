package com.ejemplos.spring.repository;

import java.time.LocalDate;
import java.util.ArrayList;

//METODOS
/**
* findAll	Returns a Collection of all the students in the Map
* findById	Searches the Map for a student with the specified ID. If found, the student is returned.
* save	    Assigns the student an ID and saves the student in the Map.
* update	Replaces the student in the Map if it exists.
* delete	Deletes the student in the Map if it exists.
*/


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ejemplos.spring.model.Event;
import com.ejemplos.spring.secundario.Recinto;
import com.ejemplos.spring.secundario.Tipo;


@Repository
public class EventRepositoryImpl implements EventRepository {
	private long currentID=0;
	//private Map<Long,Recinto> re=new HashMap<>();
	private Map<Long, Event> events = new HashMap<>();
	
	// Ojo. Esto es solo para hacer una prueba
	public void datosPrueba(){
		Recinto alfa=new Recinto("Tollobar", "San Fernando", "Parque del Este",Tipo.interior,200); // Más cómodo así.
		Recinto beta=new Recinto("Gambo", "Cadiz", "Lago de los Loros",Tipo.jardin,250);
		Recinto delta=new Recinto("Chupilandia", "Chiclana", "Estación del Flamenco",Tipo.terraza,300);
		Recinto omega=new Recinto("Restaurante la Gamba Feliz","Chiclana","Playa la Barrosa",Tipo.interior,100);
		
		events.put(++currentID, new Event(currentID, "Boda", "Un casamiento", "El señor Paco y la señora Sandra contraeran votos hasta que la muerte los separe","matrimonio.jpg","Todo el mundo vestido de gala",LocalDate.of(2023,1,23),13,20,50,alfa));
		events.put(++currentID, new Event(currentID, "Bautizo", "Recien nacido", "El recien nacido Antonio será bautizado en la iglesia de San Quintin, tras lo cual la familia vendrá a vernos para tener banquete","bautizo.png","Solo podrás entrar si acudiste al bautizo previo",LocalDate.of(2023,3,12),15,50,80,beta));
		events.put(++currentID, new Event(currentID, "Cumpleaños", "Cumpleaños feliz", "Miguelito ha cumplido 7 años, por lo que su familia va a celebrarlo con nosotros","cumple.jpg","Prohibido hacer fotos",LocalDate.now(),9,10,25,delta));
		events.put(++currentID, new Event(currentID, "Fiesta empresarial", "Fiesta de Producciones Marte", "Producciones Marte va a celebrar la navidad con nosotros","marte.jpg","Hay que vestir de etiqueta y la tarjeta de empleado",LocalDate.of(2022,12,24),21,20,30,omega));
	}
	
	public EventRepositoryImpl() {
		super();
		// Ojo. esto solo para pruebas
		this.datosPrueba();
	}

	// Return all students
	@Override
	public List<Event> findAll() {
		List<Event> list = new ArrayList<>(events.values());
		return list;
	}
	
	
	// Find the event with this id
	/*
	 * We are using java.util.Optional as a container for our Student object as it
	 * will help us handle cases where Student is null. This is purely an
	 * implementation decision and has nothing to do with REST concepts or
	 * constraints.
	 */
	public Optional<Event> findById(Long id) {
		Event event = null;

		if (events.containsKey(id)) {
			event = events.get(id);
		}
		return Optional.ofNullable(event);
	}
	
	// Busca un evento por el tipo de edificio donde se realiza.
	public List<Event> findByTipo(String tipo){
		Tipo e=Tipo.valueOf(tipo);
		List<Event> list = new ArrayList<>(events.values());
		int a=0;
		while(a<list.size()){
			if(list.get(a).getSala().getTipoRecinto()==e)
				a++;
			else
				list.remove(a);
		}
		return list;
	}
	

	// Save a new student
	public Event save(Event event) {
		event.setId(++currentID);
		events.put(event.getId(), event);
		return event;
	}

	// Update the student with this id
	public Optional<Event> update(Event event) {
		Event currentStudent = events.get(event.getId());

		if (currentStudent != null) {
			events.put(event.getId(), event);
			currentStudent = events.get(event.getId());
		}
		return Optional.ofNullable(currentStudent);
	}
	

	// Delete student with this id
	public void deleteById(Long id) {
		Event currentStudent = events.get(id);
		System.out.println("------ "+currentStudent);

		if (currentStudent != null) {
			events.remove(id);
		};
		System.out.println("------ "+events);
	}


}
