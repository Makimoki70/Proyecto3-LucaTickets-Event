package com.proyecto.spring.event.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.proyecto.spring.event.model.Event;

public interface EventRepository extends MongoRepository<Event,Long>{
}