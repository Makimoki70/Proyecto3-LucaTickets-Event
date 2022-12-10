package com.proyecto.spring.event.repository;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.proyecto.spring.event.model.Event;


/**
 * 
 * Nombre de Interfaz: EventRepository 
 * Descripcion: Interfaz de repositorio del microservicio Event. Implementa los servicios de base de datos MongoDB.
 * Tiene las querys personalizadas de busqueda de Eventos por nombre y por tipo de sala de recinto.
 * Fecha: 05/12/2022
 * @author Joel y Alberto
 * @version 0.1
 * @since 0.1
 * 
 * */
public interface EventRepository extends MongoRepository<Event,Long>{
	@Query(value="{'nombre': {$regex: ?0}}")
	public List<Event> getEventsByName(String name);
	
	@Query(value="{'sala.tipoRecinto': ?0}")
	public List<Event> getEventsByType(String type);
}