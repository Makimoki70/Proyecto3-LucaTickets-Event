package com.proyecto.spring.event.repository;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.proyecto.spring.event.model.Event;


public interface EventRepository extends MongoRepository<Event,Long>{
	
	@Query (value="{nombre:?0}")
	public List<Event> getEventName (String name);
	
}